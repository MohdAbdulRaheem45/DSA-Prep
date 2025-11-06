import java.util.Arrays;

class Solution {

    // 1️⃣ Simple Recursion (Exponential, O(2^n))
    // Not recommended for large n
    public int solveRec(int i, int[] cost) {
        if(i >= cost.length) return 0; // reached top
        // take one step or two steps
        int oneStep = solveRec(i+1, cost) + cost[i];
        int twoStep = solveRec(i+2, cost) + cost[i];
        return Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairsRec(int[] cost) {
        // Can start at step 0 or step 1
        return Math.min(solveRec(0, cost), solveRec(1, cost));
    }

    // 2️⃣ Recursion + Memoization (Top-Down DP)
    public int solveMemo(int i, int[] cost, int[] dp) {
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i]; // already computed
        int oneStep = solveMemo(i+1, cost, dp) + cost[i];
        int twoStep = solveMemo(i+2, cost, dp) + cost[i];
        dp[i] = Math.min(oneStep, twoStep);
        return dp[i];
    }

    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solveMemo(0, cost, dp), solveMemo(1, cost, dp));
    }

    // 3️⃣ Tabulation (Bottom-Up DP)
    public int minCostClimbingStairsTab(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1]; // dp[i] = min cost to reach step i
        dp[0] = 0; // starting before step 0
        dp[1] = 0; // starting before step 1

        for(int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n]; // cost to reach top
    }

    // 4️⃣ Space-Optimized DP (O(1) space)
    public int minCostClimbingStairsSpaceOpt(int[] cost) {
        int n = cost.length;
        int prev2 = 0; // cost to reach step i-2
        int prev1 = 0; // cost to reach step i-1
        int curr = 0;

        for(int i = 2; i <= n; i++){
            curr = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] cost = {10, 15, 20};

        System.out.println("Recursive: " + sol.minCostClimbingStairsRec(cost));
        System.out.println("Memoization: " + sol.minCostClimbingStairsMemo(cost));
        System.out.println("Tabulation: " + sol.minCostClimbingStairsTab(cost));
        System.out.println("Space Optimized: " + sol.minCostClimbingStairsSpaceOpt(cost));
    }
}
