import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    // 🔹 Step 1: DFS function to explore and push after visiting all neighbours
    public static void dfs(int src, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph) {
        visited[src] = true;  // mark current node as visited

        // explore all neighbours of current node
        for (int nbr : graph.get(src)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, st, graph);
            }
        }

        // 🔸 push node to stack after exploring all neighbours
        // means all its dependencies (children) are already in stack
        st.push(src);
    }

    // 🔹 Step 2: Topological Sort using DFS + Stack
    public static List<Integer> topoSort(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> st = new Stack<>();

        // run dfs for all components (if graph disconnected)
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(i, visited, st, graph);
            }
        }

        // 🔸 Step 3: Pop all nodes from stack to get topo order
        List<Integer> result = new ArrayList<>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }

    // 🔹 Step 4: Driver function (build graph and test)
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // create adjacency list for 6 nodes
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }

        // edges: 5→0, 5→2, 4→0, 4→1, 2→3, 3→1
        graph.get(5).add(0);
        graph.get(5).add(2);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        // print topological order
        System.out.println("Topological Sort (DFS): " + topoSort(graph));
    }
}
