public class BSTDeletion {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Helper: find minimum node (inorder successor)
    public static Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // Helper: find maximum node (inorder predecessor)
    public static Node findMax(Node root) {
        while (root.right != null) root = root.right;
        return root;
    }

    // Delete a node from BST
    public static Node delete(Node root, int key) {
        if (root == null) return null; // empty tree

        // 1️⃣ Go left or right depending on value
        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            // 2️⃣ Node found → check children
            if (root.left == null && root.right == null) return null; // leaf
            if (root.left == null) return root.right;               // one child
            if (root.right == null) return root.left;               // one child

            // 3️⃣ Node has two children → use inorder successor
            Node successor = findMin(root.right); // find next bigger value
            root.data = successor.data;           // replace value
            root.right = delete(root.right, successor.data); // delete successor
        }

        return root; // return updated root
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Construct sample BST
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);

        System.out.print("Original BST: ");
        inorder(root);
        System.out.println();

        // Delete 3 (node with two children)
        root = delete(root, 3);
        System.out.print("BST after deleting 3: ");
        inorder(root);
        System.out.println();

        // Delete 10 (leaf)
        root = delete(root, 10);
        System.out.print("BST after deleting 10: ");
        inorder(root);
        System.out.println();

        // Delete 8 (root with two children)
        root = delete(root, 8);
        System.out.print("BST after deleting 8: ");
        inorder(root);
        System.out.println();
    }
}

