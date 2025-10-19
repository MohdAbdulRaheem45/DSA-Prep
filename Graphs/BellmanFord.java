import java.util.*;
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // Step 1: Initialize distance array
        // Use a large number (1e8) to represent "infinity" for unreachable nodes
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000); 
        dist[src] = 0; // Distance to source is 0

        // Step 2: Relax all edges V-1 times
        // In a graph with V vertices, the longest path without a cycle has at most V-1 edges
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0]; // Start vertex of edge
                int v = edge[1]; // End vertex of edge
                int w = edge[2]; // Weight of edge

                // Relax the edge only if u is reachable
                if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w; // Update distance to v
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        // If we can still relax an edge, then a negative cycle exists
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != 100000000 && dist[u] + w < dist[v]) {
                return new int[]{-1}; // Negative cycle detected
            }
        }

        // Step 4: Return the distance array
        // Nodes that are unreachable remain at 1e8 (or "infinity")
        return dist;
    }
}
