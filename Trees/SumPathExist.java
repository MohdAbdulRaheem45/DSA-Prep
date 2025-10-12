public class SumPathExist {

    // Node class for binary tree
    static class Node {
        int d;
        Node left, right;

        Node(int v) {
            this.d = v;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if a root-to-leaf path exists with given sum
    public static boolean isSumExists(Node root, int sum) {
        if (root == null) return false; // empty tree → no path

        // Leaf node check
        if (root.left == null && root.right == null) {
            return sum == root.d; // if remaining sum equals leaf value → path exists
        }

        // Recurse on left and right subtree, subtract current node value from sum
        return isSumExists(root.left, sum - root.d) || isSumExists(root.right, sum - root.d);
    }

    public static void main(String[] args) {
        // Construct the example tree:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Check if any path has sum = 10
        System.out.println(isSumExists(root, 10)); // expected: true (1->2->7 or 1->3->6)
    }
}
