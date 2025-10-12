public class BST {

    // ✅ Node class represents each node in the Binary Search Tree
    static class Node {
        int d;           // Value stored in the node
        Node left, right; // References to left and right child

        // Constructor to create a new node
        Node(int v) {
            this.d = v;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Recursive function to insert a value into the BST
    public static Node insert(Node root, int val) {
        // Base case: if current root is null, create a new node
        if (root == null) {
            return new Node(val);
        }

        // If value is smaller, go to left subtree
        if (val < root.d) {
            root.left = insert(root.left, val);
        }
        // If value is larger, go to right subtree
        else if (val > root.d) {
            root.right = insert(root.right, val);
        }
        // If value is equal, do nothing (no duplicates handled here)

        // Return the (unchanged) root node
        return root;
    }

    // ✅ Inorder traversal (Left → Root → Right)
    // Prints the BST values in sorted order
    public static void inorder(Node root) {
        // Base case: if subtree is empty, return
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left);

        // Print current node’s value
        System.out.println(root.d + " ");

        // Traverse right subtree
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;  // Start with an empty tree

        int values[] = {8, 3, 10, 1};  // Values to insert into BST

        // Insert each value into the BST
        for (int val : values) {
            root = insert(root, val);
        }

        // Print the BST in sorted order
        System.out.println("Inorder Traversal (Sorted Order):");
        inorder(root);
    }
}
