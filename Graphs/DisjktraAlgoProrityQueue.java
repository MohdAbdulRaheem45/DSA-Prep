import java.util.*;

class Solution {

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // For undirected graph, add both directions
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Step 2: Initialize distance array and priority queue
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // initially all distances are infinity
        dist[src] = 0; // distance to source is 0

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src}); // {distance, node}

        // Step 3: Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            // Skip if we already found a better distance
            if (currDist > dist[node]) continue;

            // Explore all neighbors
            for (int[] nbr : graph.get(node)) {
                int next = nbr[0];
                int weight = nbr[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{dist[next], next});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
            {0, 1, 1},
            {0, 2, 6},
            {1, 2, 3}
        };
        int src = 0;

        int[] dist = dijkstra(V, edges, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + dist[i]);
        }
    }
}
