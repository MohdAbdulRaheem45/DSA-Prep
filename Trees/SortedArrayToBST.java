

// Definition of a Tree Node
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SortedArrayToBST {

    // Function to build a balanced BST from a sorted array
    public static Node sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    // Recursive helper function
    private static Node buildBST(int[] nums, int start, int end) {
        // Base case: invalid range
        if (start > end) return null;

        // Choose middle element as root to maintain balance
        int mid = start + (end - start) / 2;

        // Create root node
        Node root = new Node(nums[mid]);

        // Recursively build left and right subtrees
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }

    // Inorder traversal (for checking correctness)
    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    // Preorder traversal (to visualize structure)
    public static void preorderPrint(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void main(String[] args) {
        // Example sorted array
        int[] nums = {-10, -3, 0, 5, 9};

        // Build Balanced BST
        Node root = sortedArrayToBST(nums);

        System.out.print("Inorder (should match sorted array): ");
        inorderPrint(root);
        System.out.println();

        System.out.print("Preorder (tree structure): ");
        preorderPrint(root);
        System.out.println();
    }
}

