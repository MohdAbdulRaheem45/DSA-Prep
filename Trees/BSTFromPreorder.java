class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BSTFromPreorder {
    static int idx = 0;

    public static TreeNode buildBST(int[] preorder, int min, int max) {
        if (idx >= preorder.length) return null;

        int val = preorder[idx];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        idx++; // move to next element in preorder

        // all values < root.val go to left subtree
        root.left = buildBST(preorder, min, val);

        // all values > root.val go to right subtree
        root.right = buildBST(preorder, val, max);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Root: " + root.val); // 8
    }
}
