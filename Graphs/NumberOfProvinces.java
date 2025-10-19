class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        // Array to keep track of visited cities
        boolean[] visited = new boolean[n]; 
        
        int provinces = 0; // Counter for number of provinces

        // Go through each city
        for (int i = 0; i < n; i++) {
            // If the city is not visited, it's a new province
            if (!visited[i]) {
                dfs(i, isConnected, visited); // Explore all cities in this province
                provinces++;                  // Increment province count
            }
        }

        return provinces; // Return total number of provinces
    }

    // DFS function to explore all connected cities
    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true; // Mark the current city as visited

        // Explore all cities connected to the current city
        for (int j = 0; j < isConnected.length; j++) {
            // If city j is connected to the current city and not visited
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited); // Recursively visit city j
            }
        }
    }
}
