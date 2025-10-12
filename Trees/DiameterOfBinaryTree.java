class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class DiameterOfBinaryTree {

    static int maxDiameter = 0; // global variable to store diameter

    // Function to calculate height and update diameter
    static int height(Node root) {
        if (root == null) return 0; // base case

        int leftHeight = height(root.left);   // height of left subtree
        int rightHeight = height(root.right); // height of right subtree

        // Diameter through this node
        int diameterThroughNode = leftHeight + rightHeight;

        // Update maximum diameter
        maxDiameter = Math.max(maxDiameter, diameterThroughNode);

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        height(root); // start recursion
        System.out.println("Diameter: " + maxDiameter);
    }
}
