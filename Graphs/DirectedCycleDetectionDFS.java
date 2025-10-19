import java.util.*;

public class DirectedCycleDetectionDFS {

    // Function to detect cycle in directed graph using DFS
    public static boolean isCyclic(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v); // directed edge u -> v
        }

        // Step 2: Initialize visited and recursion stack arrays
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V]; // keeps track of nodes in current DFS path

        // Step 3: Check all nodes (handles disconnected graph)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, graph)) return true; // cycle detected
            }
        }

        return false; // no cycle found
    }

    // DFS helper function
    private static boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;   // mark node as visited
        recStack[node] = true;  // add node to recursion stack

        // Explore all neighbors
        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                if (dfs(nbr, visited, recStack, graph)) return true; // cycle found in deeper DFS
            } else if (recStack[nbr]) {
                // Neighbor is in recursion stack → back edge → cycle
                return true;
            }
        }

        recStack[node] = false; // remove node from recursion stack after DFS
        return false;            // no cycle found in this path
    }

    // ===================== Main for testing =====================
    public static void main(String[] args) {
        int V = 5;
        int[][] edgesWithCycle = {{0,1},{1,2},{2,3},{3,4},{4,1}}; // cycle: 1→2→3→4→1
        int[][] edgesNoCycle = {{0,1},{1,2},{2,3},{3,4}};          // no cycle

        System.out.println("Cycle exists (DFS): " + isCyclic(V, edgesWithCycle)); // true
        System.out.println("Cycle exists (DFS): " + isCyclic(V, edgesNoCycle));   // false
    }
}
