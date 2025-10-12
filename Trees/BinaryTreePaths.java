import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePaths {

    // Main function to return all root-to-leaf paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();  // List to store all paths
        if (root == null) return result;         // Edge case: empty tree
        dfs(root, "", result);                   // Start DFS from root
        return result;
    }

    // Helper DFS function
    void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;  // Base case: null node

        // Build the current path
        if (path.isEmpty()) {
            path = "" + node.val;  // First node (root)
        } else {
            path += "->" + node.val; // Append current node to path
        }

        // If leaf node → add path to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Recurse on left and right children
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    // Test the code
    public static void main(String[] args) {
        // Build example tree:
        //        1
        //       / \
        //      2   3
        //       \
        //        5
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3)
        );

        BinaryTreePaths sol = new BinaryTreePaths();
        List<String> paths = sol.binaryTreePaths(root);

        System.out.println("All root-to-leaf paths:");
        for (String p : paths) {
            System.out.println(p);
        }
    }
}
