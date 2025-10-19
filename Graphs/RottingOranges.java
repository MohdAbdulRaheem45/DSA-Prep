import java.util.*;

class Solution {
    // Directions: up, down, left, right
    public static int[] rows = {-1, 1, 0, 0};
    public static int[] cols = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all initially rotten oranges to queue and count fresh oranges
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0}); // rotten orange with time=0
                } else if(grid[i][j] == 1){
                    fresh++; // count fresh oranges
                }
            }
        }

        int minutes = 0;

        // Step 2: BFS
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            // update max minutes
            minutes = Math.max(minutes, time);

            // explore 4 directions
            for(int i = 0; i < 4; i++){
                int newRow = row + rows[i];
                int newCol = col + cols[i];

                // check bounds and if orange is fresh
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;          // rot the orange
                    fresh--;                           // decrease fresh count
                    q.add(new int[]{newRow, newCol, time + 1}); // push with updated time
                }
            }
        }

        // if fresh oranges left → impossible
        return fresh == 0 ? minutes : -1;
    }

    // ✅ Test driver
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println("Minutes to rot all oranges: " + sol.orangesRotting(grid));
    }
}
