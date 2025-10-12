public class LCA_BT_BST {

    // Node class for tree
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    // ================================
    // 1️⃣ LCA in a Binary Tree (BT)
    // Works for any binary tree, no ordering assumed
    // ================================
    public static Node lcaBT(Node root, int p, int q) {
        if (root == null) return null; // base case

        // If current node matches p or q, return it
        if (root.val == p || root.val == q) return root;

        // Recurse left and right
        Node left = lcaBT(root.left, p, q);
        Node right = lcaBT(root.right, p, q);

        // If p and q found in different subtrees → current root is LCA
        if (left != null && right != null) return root;

        // Otherwise return non-null child
        return (left != null) ? left : right;
    }

    // ================================
    // 2️⃣ LCA in a Binary Search Tree (BST)
    // Uses BST property: left < root < right
    // ================================
    public static Node lcaBST(Node root, int p, int q) {
        if (root == null) return null;

        // Both smaller → go left
        if (p < root.val && q < root.val)
            return lcaBST(root.left, p, q);

        // Both greater → go right
        else if (p > root.val && q > root.val)
            return lcaBST(root.right, p, q);

        // Split → root is LCA
        else
            return root;
    }

    public static void main(String[] args) {
        // Build a sample tree
        //         10
        //        /  \
        //       7    13
        //      / \   / \
        //     6   8 11 14

        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(13);
        root.left.left = new Node(6);
        root.left.right = new Node(8);
        root.right.left = new Node(11);
        root.right.right = new Node(14);

        int p = 6, q = 8;

        // 🔹 LCA in Binary Tree
        Node lca1 = lcaBT(root, p, q);
        System.out.println("LCA in BT of " + p + " & " + q + " = " + lca1.val);

        // 🔹 LCA in Binary Search Tree
        Node lca2 = lcaBST(root, p, q);
        System.out.println("LCA in BST of " + p + " & " + q + " = " + lca2.val);

        // More examples
        System.out.println("LCA in BT of 6 & 11 = " + lcaBT(root, 6, 11).val);
        System.out.println("LCA in BST of 11 & 14 = " + lcaBST(root, 11, 14).val);
    }
}
