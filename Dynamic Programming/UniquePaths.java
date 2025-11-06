import java.util.*;

class Solution {

    // 1️⃣ RECURSION
    public int uniquePathsRecursion(int m, int n) {
        return path(m - 1, n - 1);
    }

    private int path(int i, int j) {
        // Base conditions
        if (i == 0 && j == 0) return 1;     // reached start
        if (i < 0 || j < 0) return 0;       // out of bounds

        // Move from top + left
        return path(i - 1, j) + path(i, j - 1);
    }

    // 2️⃣ MEMOIZATION (Top-Down DP)
    public int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1); // fill with -1
        return path(m - 1, n - 1, dp);
    }

    private int path(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j]; // already computed

        // compute recursively
        return dp[i][j] = path(i - 1, j, dp) + path(i, j - 1, dp);
    }

    // 3️⃣ TABULATION (Bottom-Up DP)
    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1; // start cell
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // 4️⃣ SPACE OPTIMIZED
    public int uniquePathsSpaceOptimized(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    curr[j] = 1;
                else {
                    int up = (i > 0) ? prev[j] : 0;
                    int left = (j > 0) ? curr[j - 1] : 0;
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }

    // 🔹 Example Main
    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 3, n = 3;

        System.out.println("Recursion: " + s.uniquePathsRecursion(m, n));
        System.out.println("Memoization: " + s.uniquePathsMemo(m, n));
        System.out.println("Tabulation: " + s.uniquePathsTabulation(m, n));
        System.out.println("Space Optimized: " + s.uniquePathsSpaceOptimized(m, n));
    }
}
