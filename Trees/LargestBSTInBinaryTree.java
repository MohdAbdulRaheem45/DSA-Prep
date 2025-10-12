// Definition for a binary tree node
class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

// Info class stores data about each subtree
class Info {
    int max; // Maximum value in the subtree
    int min; // Minimum value in the subtree
    int sz;  // Size of the largest BST in the subtree

    Info(int maximum, int minimum, int size) {
        max = maximum;
        min = minimum;
        sz = size;
    }
}

public class LargestBSTInBinaryTree {

    // Helper function to calculate the size of the largest BST
    public static Info helper(Node root) {
        // Base case: empty subtree
        if (root == null) {
            // Return extreme values so parent comparisons are valid
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        // Recurse for left and right subtrees
        Info left = helper(root.left);
        Info right = helper(root.right);

        // Check if the current subtree satisfies the BST condition
        if (root.val > left.max && root.val < right.min) {
            // It forms a valid BST
            int currMin = Math.min(root.val, left.min);
            int currMax = Math.max(root.val, right.max);
            int currSize = left.sz + right.sz + 1;

            return new Info(currMax, currMin, currSize);
        }

        // Otherwise, not a valid BST — propagate invalid markers
        return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.sz, right.sz));
    }

    // Driver function
    public static void main(String[] args) {
        /*
                5
               / \
              2   4
             / \
            1   3
        */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Info result = helper(root);
        System.out.println("✅ Size of Largest BST: " + result.sz);
    }
}
