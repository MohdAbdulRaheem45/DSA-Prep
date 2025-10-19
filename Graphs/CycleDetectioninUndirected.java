import java.util.*;

public class CycleDetectioninUndirected {

    // ===================== DFS Approach =====================
    public static boolean hasCycleDFS(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                if (dfs(nbr, node, visited, graph)) return true;
            } else if (nbr != parent) {
                // Visited neighbor that is not parent -> cycle
                return true;
            }
        }
        return false;
    }

    // ===================== BFS Approach =====================
    public static boolean hasCycleBFS(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, graph)) return true;
            }
        }
        return false;
    }

    private static boolean bfs(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1}); // {node, parent}
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int nbr : graph.get(node)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(new int[]{nbr, node});
                } else if (nbr != parent) {
                    // Already visited and not parent -> cycle
                    return true;
                }
            }
        }
        return false;
    }

    // ===================== Main for testing =====================
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};

        System.out.println("Cycle detection using DFS: " + hasCycleDFS(V, edges));
        System.out.println("Cycle detection using BFS: " + hasCycleBFS(V, edges));
    }
}
