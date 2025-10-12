// Definition of a binary tree node
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BTToFlattenLinkedList {

    // Function to flatten the binary tree into a linked list (your logic)
    public static void buildll(Node root) {

        // Base case: if node is null, return
        if (root == null) return;

        // Step 1: Recursively flatten the left subtree
        buildll(root.left);

        // Step 2: Recursively flatten the right subtree
        buildll(root.right);

        // Step 3: Store references to left and right subtrees
        Node leftsub = root.left;
        Node rightsub = root.right;

        // Step 4: Set left child to null (linked list should only use right pointers)
        root.left = null;

        // Step 5: Attach left subtree as the new right subtree
        root.right = leftsub;

        // Step 6: Move to the end of the new right chain (was left subtree)
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        // Step 7: Attach the original right subtree at the end
        temp.right = rightsub;
    }

    // Helper function to print the flattened linked list
    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    // Driver code (main method)
    public static void main(String[] args) {

        // Building a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        // Flatten the tree
        buildll(root);

        // Print the flattened linked list
        System.out.println("Flattened Linked List:");
        printList(root);

        // ✅ Expected Output:
        // Flattened Linked List:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    }
}
