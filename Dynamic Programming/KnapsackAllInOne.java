import java.util.Arrays;

public class KnapsackAllInOne {

    // ======= Approach 1: Recursion =======
    // TC: O(2^n), SC: O(n) recursion stack
    static int knapsackRec(int[] wt, int[] val, int n, int W) {
        if (n == 0 || W == 0) return 0;

        if (wt[n - 1] <= W) {
            // pick or not pick
            return Math.max(val[n - 1] + knapsackRec(wt, val, n - 1, W - wt[n - 1]),
                            knapsackRec(wt, val, n - 1, W));
        } else {
            // cannot pick
            return knapsackRec(wt, val, n - 1, W);
        }
    }

    // ======= Approach 2: Memoization =======
    // TC: O(n*W), SC: O(n*W) + O(n) recursion stack
    static int knapsackMemo(int[] wt, int[] val, int n, int W, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapsackMemo(wt, val, n - 1, W - wt[n - 1], dp),
                                knapsackMemo(wt, val, n - 1, W, dp));
        } else {
            dp[n][W] = knapsackMemo(wt, val, n - 1, W, dp);
        }
        return dp[n][W];
    }

    // ======= Approach 3: Tabulation (Bottom-Up) =======
    // TC: O(n*W), SC: O(n*W)
    static int knapsackTab(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) dp[i][w] = 0;
                else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    // ======= Approach 4: Space Optimized =======
    // TC: O(n*W), SC: O(W)
    static int knapsackSpaceOpt(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                if (wt[i] <= w) {
                    curr[w] = Math.max(val[i] + prev[w - wt[i]], prev[w]);
                } else {
                    curr[w] = prev[w];
                }
            }
            prev = curr; // move to next item
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 2, 3};
        int[] val = {10, 20, 30};
        int W = 5;
        int n = wt.length;

        System.out.println("=== 0/1 Knapsack ===");

        // Approach 1: Recursion
        System.out.println("Recursion: " + knapsackRec(wt, val, n, W));

        // Approach 2: Memoization
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        System.out.println("Memoization: " + knapsackMemo(wt, val, n, W, dp));

        // Approach 3: Tabulation
        System.out.println("Tabulation: " + knapsackTab(wt, val, n, W));

        // Approach 4: Space Optimized
        System.out.println("Space Optimized: " + knapsackSpaceOpt(wt, val, n, W));
    }
}
class Solution {
    static int knapSack(int W, int wt[], int val[], int n) {
        // dp[w] → max value with capacity w
        int dp[] = new int[W + 1];

        // Base case:
        // dp[0] = 0 (0 capacity → 0 value)
        // All others are initially 0

        // Iterate through each item
        for (int i = 0; i < n; i++) {
            // Traverse weights backwards (VERY IMPORTANT)
            // So we don’t use updated values in the same iteration
            for (int w = W; w >= wt[i]; w--) {
                // Either include the item or exclude it
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        // Final answer: max value for full capacity
        return dp[W];
    }
}
