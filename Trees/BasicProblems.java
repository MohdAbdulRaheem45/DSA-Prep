// Program: BasicProblems
// Description: Demonstrates fundamental binary tree operations —
// counting total nodes, counting leaf nodes, and finding tree height.

public class BasicProblems {

    // ------------------- Node Definition -------------------
    // Inner static class representing a single node in the binary tree.
    static class Node {
        int data;      // Value stored in the node
        Node left;     // Reference to the left child
        Node right;    // Reference to the right child

        // Constructor to create a new node with given value
        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // Root node of the binary tree (initially empty)
    static Node root = null;

    // ------------------- Function 1: Count Total Nodes -------------------
    
    public static int countNodes(Node root) {
        // Base case: if tree/subtree is empty
        if (root == null) return 0;

        // Count = current node (1) + nodes in left subtree + nodes in right subtree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // ------------------- Function 2: Count Leaf Nodes -------------------
    /**
     * Counts the number of leaf nodes in the binary tree.
     * (A leaf node has no children)
     *
     * @param root Root node of the binary tree
     * @return Number of leaf nodes
     */
    public static int countLeaves(Node root) {
        // Base case: empty tree
        if (root == null) return 0;

        // If both children are null → this node is a leaf
        if (root.left == null && root.right == null) return 1;

        // Otherwise, recursively count leaves in left and right subtrees
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // ------------------- Function 3: Find Height of Tree -------------------
    /**
     * Finds the height of the binary tree.
     * Height = number of nodes along the longest path from root to a leaf.
     *
     * @param root Root node of the binary tree
     * @return Height of the tree
     */
    public static int height(Node root) {
        // Base case: empty tree has height 0
        if (root == null) return 0;

        // Height = 1 (for current node) + max height of left and right subtrees
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // ------------------- Main Function -------------------
    public static void main(String[] args) {

        // --------- Constructing the Binary Tree ---------
        // Tree structure:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6

        Node first = new Node(1);
        root = first;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // --------- Function Outputs ---------
        System.out.println("Total number of nodes in the tree: " + countNodes(root));
        System.out.println("Number of leaf nodes in the tree: " + countLeaves(root));
        System.out.println("Height of the tree: " + height(root));
    }
}
