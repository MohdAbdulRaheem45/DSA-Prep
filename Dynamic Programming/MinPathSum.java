import java.util.*;

class Solution {

    // 🔹 1️⃣ PURE RECURSION
    // Time: Exponential, Space: O(path length)
    public int minPathSumRecursion(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return path(m - 1, n - 1, grid);
    }

    private int path(int i, int j, int[][] grid) {
        // Base case: reached top-left cell
        if (i == 0 && j == 0) return grid[i][j];
        // Out of bounds → invalid, return large number
        if (i < 0 || j < 0) return (int) 1e9;

        // Move up and left
        int up = grid[i][j] + path(i - 1, j, grid);
        int left = grid[i][j] + path(i, j - 1, grid);

        // Return minimum sum path
        return Math.min(up, left);
    }

    // 🔹 2️⃣ MEMOIZATION (Top-Down DP)
    // Time: O(m*n), Space: O(m*n) + Recursion stack
    public int minPathSumMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return pathMemo(m - 1, n - 1, grid, dp);
    }

    private int pathMemo(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return (int) 1e9;
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + pathMemo(i - 1, j, grid, dp);
        int left = grid[i][j] + pathMemo(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    // 🔹 3️⃣ TABULATION (Bottom-Up DP)
    // Time: O(m*n), Space: O(m*n)
    public int minPathSumTabulation(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if (i > 0) up += dp[i - 1][j];
                    else up += (int) 1e9;

                    if (j > 0) left += dp[i][j - 1];
                    else left += (int) 1e9;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

    // 🔹 4️⃣ SPACE OPTIMIZED (1D DP
