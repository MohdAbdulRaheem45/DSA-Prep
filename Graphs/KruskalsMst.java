import java.util.*;

class Solution {

    // ✅ Disjoint Set Union (DSU) class
    static class DisjointSet {
        int[] parent;  // parent[i] = ultimate parent of node i
        int[] rank;    // rank[i] = height of tree for union by rank
        int[] size;    // size[i] = size of set for union by size

        // ✅ Constructor to initialize DSU
        DisjointSet(int V) {
            parent = new int[V];
            rank = new int[V];
            size = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;  // initially each node is its own parent
                rank[i] = 0;
                size[i] = 1;
            }
        }

        // ✅ Find ultimate parent with path compression
        public int findUpr(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findUpr(parent[node]); // path compression
        }

        // ✅ Union by Rank
        public void unionByRank(int u, int v) {
            int pu = findUpr(u);
            int pv = findUpr(v);
            if (pu == pv) return; // already in same set

            if (rank[pu] > rank[pv]) {
                parent[pv] = pu; // attach smaller rank under larger
            } else if (rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv; // attach and increment rank
                rank[pv]++;
            }
        }

        // ✅ Union by Size
        public void unionBySize(int u, int v) {
            int pu = findUpr(u);
            int pv = findUpr(v);
            if (pu == pv) return; // already connected

            if (size[pu] > size[pv]) {
                parent[pv] = pu;        // attach smaller set under larger
                size[pu] += size[pv];   // update size
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }

    // ✅ Kruskal’s Algorithm to find MST weight
    public int spanningTree(int V, int[][] edges) {
        // Step 1: Sort all edges by weight (ascending)
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int mstWeight = 0;             // total weight of MST
        int edgesDone = 0;             // count of edges added to MST
        DisjointSet ds = new DisjointSet(V);

        // Step 2: Iterate through all edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // Step 3: Add edge if it doesn't form a cycle
            if (ds.findUpr(u) != ds.findUpr(v)) {
                ds.unionByRank(u, v);   // merge components
                mstWeight += wt;        // add weight
                edgesDone++;
                if (edgesDone == V - 1) break; // MST complete
            }
        }

        return mstWeight;
    }

    // ✅ Main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int V = 4; // number of vertices
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        int mstWeight = sol.spanningTree(V, edges);
        System.out.println("Total weight of MST: " + mstWeight);
    }
}
