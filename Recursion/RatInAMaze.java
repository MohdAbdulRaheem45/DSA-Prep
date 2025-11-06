// 🔹 Time Complexity: O(4^(N*N))  -> Each cell has 4 possible directions
// 🔹 Space Complexity: O(N*N)     -> Recursion stack + visited matrix

import java.util.*;

class Solution {
    // Helper function to explore all paths
    public static void solve(int i, int j, int[][] maze, int n,
                             ArrayList<String> ans, String path, int[][] vis) {
        // Base case: reached destination
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        // Mark current cell visited
        vis[i][j] = 1;

        // Move Down
        if (i + 1 < n && maze[i + 1][j] == 1 && vis[i + 1][j] == 0)
            solve(i + 1, j, maze, n, ans, path + "D", vis);

        // Move Left
        if (j - 1 >= 0 && maze[i][j - 1] == 1 && vis[i][j - 1] == 0)
            solve(i, j - 1, maze, n, ans, path + "L", vis);

        // Move Right
        if (j + 1 < n && maze[i][j + 1] == 1 && vis[i][j + 1] == 0)
            solve(i, j + 1, maze, n, ans, path + "R", vis);

        // Move Up
        if (i - 1 >= 0 && maze[i - 1][j] == 1 && vis[i - 1][j] == 0)
            solve(i - 1, j, maze, n, ans, path + "U", vis);

        // 🔁 Backtrack: unmark before returning
        vis[i][j] = 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];

        // If start cell is blocked, no path possible
        if (m[0][0] == 0) return ans;

        solve(0, 0, m, n, ans, "", vis);
        return ans;
    }
}
