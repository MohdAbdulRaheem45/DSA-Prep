class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SubtreeOfAnotherTree {

    // ✅ Helper function: checks if two trees are exactly identical
    static boolean isIdentical(Node a, Node b) {
        // Case 1: both are null → identical
        if (a == null && b == null) return true;

        // Case 2: one is null → not identical
        if (a == null || b == null) return false;

        // Case 3: current values differ → not identical
        if (a.val != b.val) return false;

        // ✅ Recurse for both left and right subtrees
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    // ✅ Main function: checks if subRoot is a subtree of root
    static boolean isSubtree(Node root, Node subRoot) {
        // Case 1: empty subRoot → always a subtree
        if (subRoot == null) return true;

        // Case 2: root becomes null but subRoot not → false
        if (root == null) return false;

        // Case 3: if current nodes match → check for identical structure
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot))
                return true; // found exact match
        }

        // Case 4: otherwise, check in left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // 🌳 MAIN TREE (root)
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        // 🌿 SUBTREE (subRoot)
        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        // ✅ Output: should print true (subRoot is part of root)
        System.out.println(isSubtree(root, subRoot));
    }
}
