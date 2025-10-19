import java.util.*;

public class GraphDemo {

    // Function to create adjacency list for undirected graph
    public static List<List<Integer>> printUndirectedGraph(int V, int[][] edges) {
        // Pre-size ArrayList for performance
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Fill adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }
        return graph;
    }

    // Function to create adjacency list for directed graph
    public static List<List<Integer>> printDirectedGraph(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); // directed only u -> v
        }
        return graph;
    }

    // Helper function to print adjacency list
    public static void printGraph(List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int nbr : graph.get(i)) {
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};

        System.out.println("Undirected Graph:");
        List<List<Integer>> undirected = printUndirectedGraph(V, edges);
        printGraph(undirected);

        System.out.println("\nDirected Graph:");
        List<List<Integer>> directed = printDirectedGraph(V, edges);
        printGraph(directed);
    }
}
