/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Use static prev for single run
    static TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;

        // Recur for left subtree
        if (root.left != null) {
            int leftMin = getMinimumDifference(root.left);
            ans = Math.min(ans, leftMin);
        }

        // Compare with previous node in inorder traversal
        if (prev != null) {
            ans = Math.min(ans, root.val - prev.val);
        }

        // Update prev to current node
        prev = root;

        // Recur for right subtree
        if (root.right != null) {
            int rightMin = getMinimumDifference(root.right);
            ans = Math.min(ans, rightMin);
        }

        return ans;
    }
}
