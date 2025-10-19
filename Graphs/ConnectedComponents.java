import java.util.ArrayList;

public class ConnectedComponents {

    // ===================== DFS =====================
    // Marks all nodes reachable from 'src' as visited
    public static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[src] = true;

        for (int nbr : graph.get(src)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, graph);
            }
        }
    }

    // ===================== Count Connected Components =====================
    public static int countComponents(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        int count = 0;

        // Visit all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;           // new component found
                dfs(i, visited, graph); // mark all nodes in this component
            }
        }
        return count;
    }

    // ===================== Main =====================
    public static void main(String[] args) {
        int V = 7; // number of nodes
        int[][] edges = {
            {0,1}, {1,2}, {3,4}, {5,6} // example edges
        };

        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected graph
        }

        // Count connected components
        int components = countComponents(graph);
        System.out.println("Number of connected components: " + components);
    }
}
