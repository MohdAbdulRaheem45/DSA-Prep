import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalGraph {

    // BFS function
    public static void bfs(int start, ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];  // Keep track of visited nodes
        Queue<Integer> q = new LinkedList<>();  // Queue for BFS

        // Start BFS from the starting node
        q.add(start);
        visited[start] = true;  // Mark start as visited

        while (!q.isEmpty()) {
            int cur = q.poll();         // Remove node from queue
            System.out.print(cur + " "); // Process the node (print here)

            // Visit all unvisited neighbors
            for (int nbr : graph.get(cur)) {
                if (!visited[nbr]) {
                    q.add(nbr);       // Add neighbor to queue
                    visited[nbr] = true; // Mark neighbor as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;  // Number of nodes
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected graph edges
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);

        // Print adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int nbr : graph.get(i)) System.out.print(nbr + " ");
            System.out.println();
        }

        // Call BFS from node 0
        System.out.print("BFS Traversal: ");
        bfs(0, graph);
    }
}
