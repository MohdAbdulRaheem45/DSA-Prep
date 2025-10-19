import java.util.*;

public class GraphBasics {
    static class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            this.node=n;
            this.weight=w;
        }
    }
    public static void main(String[] args) {
        int V = 5; // number of nodes (0 to V-1)

        // -----------------------------
        // 1. UNWEIGHTED GRAPH
        // -----------------------------
        // Using adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected edges
        addEdgeUndirected(graph, 0, 1);
        addEdgeUndirected(graph, 0, 2);
        addEdgeUndirected(graph, 1, 3);
        addEdgeUndirected(graph, 2, 4);

        System.out.println("Undirected Unweighted Graph:");
        printGraph(graph);

        // Directed edges
        ArrayList<ArrayList<Integer>> dirGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) dirGraph.add(new ArrayList<>());

        addEdgeDirected(dirGraph, 0, 1);
        addEdgeDirected(dirGraph, 0, 2);
        addEdgeDirected(dirGraph, 1, 3);
        addEdgeDirected(dirGraph, 2, 4);

        System.out.println("\nDirected Unweighted Graph:");
        printGraph(dirGraph);

        // -----------------------------
        // 2. WEIGHTED GRAPH
        // -----------------------------
        // Using Pair(node, weight)
        ArrayList<ArrayList<Pair>> wGraph = new ArrayList<>();
        for(int i=0;i<V;i++) wGraph.add(new ArrayList<>());

        addEdgeUndirectedWeighted(wGraph, 0, 1, 5);
        addEdgeUndirectedWeighted(wGraph, 0, 2, 3);
        addEdgeUndirectedWeighted(wGraph, 1, 3, 2);
        addEdgeUndirectedWeighted(wGraph, 2, 4, 4);

        System.out.println("\nUndirected Weighted Graph:");
        printWeightedGraph(wGraph);
    }

    // -----------------------------
    // Methods for UNWEIGHTED GRAPH
    // -----------------------------
    static void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // because undirected
    }

    static void addEdgeDirected(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v); // only u -> v
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for(int i=0;i<graph.size();i++){
            System.out.print(i + " -> ");
            for(int nbr : graph.get(i)){
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }

    // -----------------------------
    // Methods for WEIGHTED GRAPH
    // -----------------------------
    static void addEdgeUndirectedWeighted(ArrayList<ArrayList<Pair>> graph, int u, int v, int w) {
        graph.get(u).add(new Pair(v,w));
        graph.get(v).add(new Pair(u,w)); // because undirected
    }

    static void printWeightedGraph(ArrayList<ArrayList<Pair>> graph) {
        for(int i=0;i<graph.size();i++){
            System.out.print(i + " -> ");
            for(Pair p : graph.get(i)){
                System.out.print("("+p.node+","+p.weight+") ");
            }
            System.out.println();
        }
    }
}
