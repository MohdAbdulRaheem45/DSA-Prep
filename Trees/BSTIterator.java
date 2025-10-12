import java.util.Stack;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

// BST Iterator class
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    // Constructor – push all the left nodes (inorder starts from smallest)
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }

    // Helper: pushes all left children onto stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);   // push current node
            node = node.left;   // move to its left
        }
    }

    // Returns the next smallest number
    public int next() {
        // Pop top element from stack (this is current smallest)
        TreeNode top = stack.pop();
        // If this node has a right subtree, push all its left nodes
        if (top.right != null) {
            pushAllLeft(top.right);
        }
        return top.val;
    }

    // Returns whether we still have next smallest element
    public boolean hasNext() {
        return stack.size()>0;
    }

    // Driver main
    public static void main(String[] args) {
        /*
                    7
                   / \
                  3   15
                     /  \
                    9    20
        */

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);

        System.out.print("Inorder Traversal using Iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
