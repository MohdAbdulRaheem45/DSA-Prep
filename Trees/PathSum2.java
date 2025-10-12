import java.util.*;



public class PathSum2 {
    static class Node {
    int val;
    Node left, right;

    Node(int v) {
        this.val = v;
        this.left = null;
        this.right = null;
    }
}

    // Function to return all root-to-leaf paths with given sum
    public static List<List<Integer>> sumPath(Node root, int sum) {
        List<List<Integer>> res = new ArrayList<>(); // store all valid paths
        List<Integer> path = new ArrayList<>();      // current path
        if (root == null) return res;                // edge case: empty tree
        dfs(root, sum, path, res);                   // start DFS
        return res;
    }

    // Helper DFS function
    public static void dfs(Node root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return; // base case

        // Add current node to path
        path.add(root.val);

        // Leaf node check: if remaining sum equals current node value
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path)); // store a COPY of path in result
        } else {
            // Recurse left and right with remaining sum
            dfs(root.left, sum - root.val, path, res);
            dfs(root.right, sum - root.val, path, res);
        }

        // Backtrack: remove last node before returning to parent
        path.remove(path.size() - 1);
    }

    // Main function to test the code
    public static void main(String[] args) {
        // Construct example tree:
        //         5
        //       /   \
        //      4     8
        //     /     / \
        //    11    13  4
        //   /  \        \
        //  7    2        1
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        int targetSum = 22;

        List<List<Integer>> paths = sumPath(root, targetSum);

        // Print all paths
        System.out.println("All root-to-leaf paths with sum = " + targetSum + ":");
        for (List<Integer> p : paths) {
            System.out.println(p);
        }
    }
}
