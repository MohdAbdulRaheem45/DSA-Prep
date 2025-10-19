import java.util.ArrayList;

public class DFSTraversalGraph {
    public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> graph){
    visited[node]=true;
    System.out.println(node);
    
    for(int nbr:graph.get(node)){
        if(!visited[nbr]) {
            dfs(nbr,visited,graph);
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
        boolean[] visited=new boolean[V];
        dfs(0,visited, graph);
}
} 
