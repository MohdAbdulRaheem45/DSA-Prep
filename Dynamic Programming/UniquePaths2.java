import java.util.*;

class Solution2 {

    // 1️⃣ RECURSION
    public int uniquePathsWithObstaclesRecursion(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return path(m - 1, n - 1, grid);
    }

    private int path(int i, int j, int[][] grid) {
        // if obstacle found
        if (i >= 0 && j >= 0 && grid[i][j] == 1) return 0;
        // reached start
        if (i == 0 && j == 0) return 1;
        // out of bounds
        if (i < 0 || j < 0) return 0;

        return path(i - 1, j, grid) + path(i, j - 1, grid);
    }

    // 2️⃣ MEMOIZATION
    public int uniquePathsWithObstaclesMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return path(m - 1, n - 1, grid, dp);
    }

    private int path(int i, int j, int[][] grid, int[][] dp) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = path(i - 1, j, grid, dp) + path(i, j - 1, grid, dp);
    }

    // 3️⃣ TABULATION
    public int uniquePathsWithObstaclesTabulation(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0; // obstacle
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // 🔹 Example Main
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println("Recursion: " + s.uniquePathsWithObstaclesRecursion(grid));
        System.out.println("Memoization: " + s.uniquePathsWithObstaclesMemo(grid));
        System.out.println("Tabulation: " + s.uniquePathsWithObstaclesTabulation(grid));
    }
}
