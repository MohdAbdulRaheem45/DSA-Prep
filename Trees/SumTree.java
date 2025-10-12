 

public class SumTree {
    static class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

    // Function to convert a binary tree to a sum tree
    static int toSumTree(Node root) {
        // Base case: if node is null, return 0
        if (root == null) return 0;

        // Recursively convert left and right subtrees
        

        // Store the current node's original value
        int oldVal = root.val;

        // Update current node's value = sum of left and right subtree values
        root.val = toSumTree(root.left)+ toSumTree(root.right);

        // Return the sum including original node's value
        return root.val + oldVal;
    }

    // Function to print inorder traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Original Tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        System.out.println("Original Inorder:");
        inorder(root);
        System.out.println();

        // Transform to Sum Tree
        toSumTree(root);

        System.out.println("Sum Tree Inorder:");
        inorder(root);
        System.out.println();
    }
}
