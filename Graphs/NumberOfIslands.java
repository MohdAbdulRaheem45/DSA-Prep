class Solution {

    // ✅ DFS to mark all connected land ('1') as visited
    public static void dfs(int i, int j, boolean[][] visited, char[][] grid, int n, int m) {
        // Boundary check + already visited + water check
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] != '1') 
            return;

        visited[i][j] = true; // mark current cell as visited

        // Explore all 4 directions
        dfs(i - 1, j, visited, grid, n, m); // top
        dfs(i, j + 1, visited, grid, n, m); // right
        dfs(i + 1, j, visited, grid, n, m); // bottom
        dfs(i, j - 1, visited, grid, n, m); // left
    }

    // ✅ Main function to count islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[n][m];

        // Traverse each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If cell is land and not visited, start DFS
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid, n, m);
                    islands++; // count this island
                }
            }
        }

        return islands;
    }

    // ✅ Test driver
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands: " + sol.numIslands(grid));
    }
}
