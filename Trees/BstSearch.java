// ✅ A simple program to search for a value in a Binary Search Tree (BST)
public class BstSearch {

    // ✅ Node class to represent each node in the BST
    static class Node {
        int data;       // value of the current node
        Node left;      // pointer to left child
        Node right;     // pointer to right child

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ Function to search for a target value in a BST
    public static boolean search(Node root, int target) {
        // Base case 1: if tree is empty or we reach a null node, element not found
        if (root == null)
            return false;

        // Base case 2: if current node matches target, element found
        if (root.data == target)
            return true;

        // If target is greater than current node, search in the right subtree
        if (target > root.data) {
            return search(root.right, target);
        }

        // Otherwise, search in the left subtree
        return search(root.left, target);
    }

    public static void main(String[] args) {
        // ✅ Manually constructing a small BST
        /*
                8
               / \
              3   10
             /
            1
        */
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);

        // ✅ Searching for the target value 10 in the BST
        System.out.println(search(root, 10)); // Output: true (10 exists in the tree)
    }
}
