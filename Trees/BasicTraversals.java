import java.util.LinkedList;
import java.util.Queue;

// Class containing all basic tree traversal methods
public class BasicTraversals {

    // Node class representing each node of the binary tree
    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize a new node
        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // Root node of the binary tree
    static Node root = null;

    // ------------------ TRAVERSALS ------------------

    // 1️⃣ Preorder Traversal: (Root → Left → Right)
    public static void preOrder(Node root) {
        if (root == null) return; // Base case: if tree/subtree is empty

        System.out.print(root.data + " ");  // Visit the root
        preOrder(root.left);                // Traverse left subtree
        preOrder(root.right);               // Traverse right subtree
    }

    // 2️⃣ Inorder Traversal: (Left → Root → Right)
    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);                 // Traverse left subtree
        System.out.print(root.data + " ");  // Visit the root
        inOrder(root.right);                // Traverse right subtree
    }

    // 3️⃣ Postorder Traversal: (Left → Right → Root)
    public static void PostOrder(Node root) {
        if (root == null) return;

        PostOrder(root.left);               // Traverse left subtree
        PostOrder(root.right);              // Traverse right subtree
        System.out.print(root.data + " ");  // Visit the root
    }

    // 4️⃣ Level Order Traversal (Breadth First Search)
    public static void LevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>(); // Queue to hold nodes level-wise
        q.add(root);                        // Start with the root node

        // Continue until the queue becomes empty
        while (!q.isEmpty()) {
            Node cur = q.poll();            // Remove front node from queue
            System.out.print(cur.data + " "); // Print current node

            // Add left child to the queue (if exists)
            if (cur.left != null) q.add(cur.left);

            // Add right child to the queue (if exists)
            if (cur.right != null) q.add(cur.right);
        }
    }

    // ------------------ MAIN METHOD ------------------
    public static void main(String[] args) {

        // Create binary tree manually
        Node first = new Node(1);
        root = first;

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Tree structure:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6

        // Perform and print each traversal
        System.out.print("Preorder Traversal: ");
        preOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        PostOrder(root);
        System.out.println();

        System.out.print("Level Order Traversal: ");
        LevelOrder(root);
    }
}
