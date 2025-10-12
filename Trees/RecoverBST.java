// Definition of a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class RecoverBST {
    // Pointers to track the two nodes that are swapped
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null; // Tracks previously visited node in inorder traversal

    // Main function to recover the BST
    public void recoverTree(TreeNode root) {
        // Step 1: Inorder traversal to find the two swapped nodes
        inorder(root);
        
        // Step 2: Swap the values of the two nodes to restore BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Inorder traversal to detect the swapped nodes
    private void inorder(TreeNode root) {
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left);

        // Detect violation: previous node's value should be less than current node
        if (prev != null && prev.val > root.val) {
            // First violation
            if (first == null) first = prev;
            // Second violation (or adjacent swap)
            second = root;
        }

        // Update previous node to current
        prev = root;

        // Traverse right subtree
        inorder(root.right);
    }

    // Helper function to print inorder traversal (for verification)
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Driver code
    public static void main(String[] args) {
        RecoverBST tree = new RecoverBST();

        // Construct a BST with swapped nodes 3 and 2
        /*
                3
               / \
              1   4
                 /
                2
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Inorder before recovery:");
        tree.printInorder(root); // Output: 1 3 2 4
        System.out.println();

        // Recover the BST
        tree.recoverTree(root);

        System.out.println("Inorder after recovery:");
        tree.printInorder(root); // Output: 1 2 3 4
    }
}

