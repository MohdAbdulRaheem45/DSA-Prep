import java.util.*;

public class BFSSimpleShortestPath {

    // Function to find shortest path (in terms of edges) from a source node in an unweighted graph
    public static void bfsShortestPath(int V, ArrayList<ArrayList<Integer>> graph, int src) {
        int[] dist = new int[V]; // stores distance from src to every node
        Arrays.fill(dist, -1); // initially mark all as unreachable (-1)

        Queue<Integer> q = new LinkedList<>();
        q.add(src);       // start BFS from source node
        dist[src] = 0;    // distance of source from itself = 0

        // Standard BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll(); // remove current node from queue

            // Visit all its neighbors
            for (int nbr : graph.get(node)) {
                // if neighbor not visited yet
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[node] + 1; // update distance (parent dist + 1)
                    q.add(nbr);                 // add neighbor to queue for further exploration
                }
            }
        }

        // Print the final shortest distances from src
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " → " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected graph edges
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);

        // Call BFS shortest path from source node 0
        bfsShortestPath(V, graph, 0);
    }
}
