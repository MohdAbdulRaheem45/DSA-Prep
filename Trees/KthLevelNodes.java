import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class KthLevelNodes {

    // ===== BFS Approach (Level-order traversal) =====
    static int countNodesAtLevelBFS(Node root, int k) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes at current level

            // If this is the desired level, return count
            if (level == k)
                return size;

            // Process nodes at current level and add their children
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++; // move to next level
        }

        return 0; // level > height of tree
    }

    // ===== Recursive Approach =====
    static int countNodesAtLevelRecursive(Node root, int k) {
        if (root == null) return 0; // base case: null node
        if (k == 1) return 1;       // current node is at desired level

        // count nodes in left and right subtree at level k-1
        return countNodesAtLevelRecursive(root.left, k - 1)
             + countNodesAtLevelRecursive(root.right, k - 1);
    }

    // ===== Main Function =====
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \    \
             4   5    6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int k = 3;

        // BFS method
        int bfsCount = countNodesAtLevelBFS(root, k);
        System.out.println("BFS: Nodes at level " + k + " = " + bfsCount);

        // Recursive method
        int recCount = countNodesAtLevelRecursive(root, k);
        System.out.println("Recursive: Nodes at level " + k + " = " + recCount);
    }
}
