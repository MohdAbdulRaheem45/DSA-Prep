public class BSTMinMax {

    // ✅ Node class for BST
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Function to find the minimum value in BST
    public static Node findMin(Node root) {
        if (root == null) return null; // If tree is empty, return null

        // Keep going left until there is no left child
        while (root.left != null) {
            root = root.left; // Move to left child
        }

        // Leftmost node is the minimum
        return root;
    }

    // ✅ Function to find the maximum value in BST
    public static Node findMax(Node root) {
        if (root == null) return null; // If tree is empty, return null

        // Keep going right until there is no right child
        while (root.right != null) {
            root = root.right; // Move to right child
        }

        // Rightmost node is the maximum
        return root;
    }

    // ✅ Inorder traversal to print BST
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Construct a sample BST
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);

        System.out.print("Inorder BST: ");
        inorder(root);
        System.out.println();

        // Find min and max using iterative approach
        Node minNode = findMin(root);
        Node maxNode = findMax(root);

        System.out.println("Minimum value in BST: " + (minNode != null ? minNode.data : "Tree is empty"));
        System.out.println("Maximum value in BST: " + (maxNode != null ? maxNode.data : "Tree is empty"));
    }
}
