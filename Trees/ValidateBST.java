public class ValidateBST {

    // Node class for BST
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Function to check if a tree is BST
    public static boolean isBST(Node root) {
        // Initial range: (-∞, ∞)
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function with min and max range
    private static boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true; // empty tree is BST

        // If node value violates min/max constraint → not BST
        if (node.data <= min || node.data >= max) return false;

        // Recur for left and right subtrees with updated ranges
        boolean leftOk = isBSTUtil(node.left, min, node.data);   // left < node
        boolean rightOk = isBSTUtil(node.right, node.data, max); // right > node

        return leftOk && rightOk; // valid only if both subtrees are BST
    }

    // Inorder traversal to check visually
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);

        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();

        System.out.println("Is BST? " + isBST(root)); // true
    }
}
