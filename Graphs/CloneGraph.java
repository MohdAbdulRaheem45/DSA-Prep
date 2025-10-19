import java.util.*;


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {

    public Node cloneGraph(Node node) {
        // 🧱 Base Case: if input graph is empty
        if (node == null) return null;

        // 🔗 Map to store original node → cloned node
        HashMap<Node, Node> map = new HashMap<>();

        // 🧺 Queue for BFS traversal (stores original nodes)
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        // 🧬 Step 1: Clone the first node and put it in the map
        map.put(node, new Node(node.val));

        // 🌐 Step 2: Start BFS traversal
        while (!q.isEmpty()) {
            // Take out current original node
            Node cur = q.poll();

            // Go through all its neighbors
            for (Node nbr : cur.neighbors) {

                // 👀 Step 3: If neighbor hasn’t been cloned yet
                if (!map.containsKey(nbr)) {
                    // Create its clone
                    map.put(nbr, new Node(nbr.val));
                    // Add the original neighbor to queue to process its neighbors later
                    q.add(nbr);
                }

                // 🔁 Step 4: Connect the cloned current node with cloned neighbor
                map.get(cur).neighbors.add(map.get(nbr));
            }
        }

        // ✅ Step 5: Return the clone corresponding to the starting node
        return map.get(node);
    }

    // 🧪 Test Driver
    public static void main(String[] args) {
        // Create a sample graph:
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Solution sol = new Solution();
        Node clone = sol.cloneGraph(n1);

        System.out.println("✅ Graph cloned successfully!");
    }
}
