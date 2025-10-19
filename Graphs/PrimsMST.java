import java.util.*;

// Class to solve Minimum Spanning Tree using Prim's algorithm
class Solution {

    // Helper class to store a node and the weight of the edge
    static class Pair {
        int node;    // destination node
        int weight;  // weight of edge
        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    // Function to calculate MST weight
    public int spanningTree(int V, int[][] edges) {
        // Create adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add all edges to the adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[V]; // keep track of visited nodes
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)); 
        // PriorityQueue to pick edge with minimum weight

        pq.add(new Pair(0, 0)); // start from node 0 with weight 0
        int mstWeight = 0;      // total weight of MST

        while (!pq.isEmpty()) {
            Pair p = pq.poll();  // get edge with smallest weight
            int u = p.node;
            int wt = p.weight;

            // If node already visited, skip
            if (visited[u]) continue;

            // Include this node in MST
            visited[u] = true;
            mstWeight += wt;

            // Add all adjacent edges to the PQ
            for (Pair next : graph.get(u)) {
                if (!visited[next.node]) {
                    pq.add(new Pair(next.node, next.weight));
                }
            }
        }

        return mstWeight;
    }

    // Main function to test the code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example graph with 4 vertices
        int V = 4;
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        int mstWeight = sol.spanningTree(V, edges);
        System.out.println("Weight of Minimum Spanning Tree: " + mstWeight);
    }
}
