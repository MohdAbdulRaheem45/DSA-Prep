public class IdenticalTree {

    // Node class for Binary Tree
    static class Node {
        int data;        // value stored in the node
        Node left;       // left child
        Node right;      // right child

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if two trees are identical
    public static boolean identicaltree(Node r1, Node r2) {

        // ✅ Case 1: If both trees are empty → identical
        if (r1 == null && r2 == null) return true;

        // ❌ Case 2: If one tree is empty and other is not → not identical
        if (r1 == null || r2 == null) return false;

        // ❌ Case 3: If data at current nodes differ → not identical
        if (r1.data != r2.data) return false;

        // ✅ Case 4: Otherwise, check both subtrees
        // Left subtrees must be identical AND right subtrees must be identical
        return identicaltree(r1.left, r2.left) && identicaltree(r1.right, r2.right);
    }

    public static void main(String[] args) {

        // Create first tree
        Node r1 = new Node(1);
        r1.left = new Node(2);
        r1.right = new Node(3);

        // Create second tree
        Node r2 = new Node(1);
        r2.left = new Node(2);
        r2.right = new Node(3);

        // Compare the two trees
        if (identicaltree(r1, r2))
            System.out.println("✅ Trees are identical");
        else
            System.out.println("❌ Trees are NOT identical");
    }
}
