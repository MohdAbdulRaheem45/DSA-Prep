import java.util.*;

// Node class for Binary Tree
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BuildTreeUisnsInoderandPreorder {

    // Function to build tree using preorder and inorder arrays
    public static Node buildBST(int[] preorder, int[] inorder) {
        // Store indices of inorder elements for O(1) lookup
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Build the tree recursively
        return buildTree(inorder, 0, inorder.length - 1,
                         preorder, 0, preorder.length - 1,
                         map);
    }

    // Recursive helper function
    private static Node buildTree(int[] inorder, int inStart, int inEnd,
                                  int[] preorder, int preStart, int preEnd,
                                  HashMap<Integer, Integer> map) {

        // Base case: if range is invalid
        if (inStart > inEnd || preStart > preEnd) return null;

        // Root is always first element of current preorder range
        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);

        // Find root index in inorder array
        int inRootIndex = map.get(rootVal);

        // Number of nodes in left subtree
        int numsLeft = inRootIndex - inStart;

        // Recursively build left subtree
        root.left = buildTree(inorder, inStart, inRootIndex - 1,
                              preorder, preStart + 1, preStart + numsLeft,
                              map);

        // Recursively build right subtree
        root.right = buildTree(inorder, inRootIndex + 1, inEnd,
                               preorder, preStart + numsLeft + 1, preEnd,
                               map);

        return root;
    }

    // Print inorder traversal to verify correctness
    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {

        // Example input
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Build tree
        Node root = buildBST(preorder, inorder);

        // Print inorder of built tree
        System.out.print("Inorder of constructed tree: ");
        inorderPrint(root);
        System.out.println();
    }
}
