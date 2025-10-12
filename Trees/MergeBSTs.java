import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
    TreeNode(int v, TreeNode left, TreeNode right) {
        val = v;
        this.left = left;
        this.right = right;
    }
}

public class MergeBSTs {

    // Step 1: Inorder traversal to get sorted list
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Step 2: Merge two sorted lists
    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));
        return merged;
    }

    // Step 3: Build balanced BST from sorted list
    public static TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);
        return root;
    }

    // Main function to merge two BSTs
    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Get sorted lists from both BSTs
        inorder(root1, list1);
        inorder(root2, list2);

        // Merge the two sorted lists
        List<Integer> mergedList = mergeLists(list1, list2);

        // Build balanced BST from merged list
        return sortedListToBST(mergedList, 0, mergedList.size() - 1);
    }

    // Utility: Print BST inorder
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Example usage
    public static void main(String[] args) {
        // BST 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        // BST 2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        TreeNode mergedRoot = mergeBSTs(root1, root2);

        System.out.print("Inorder of merged BST: ");
        printInorder(mergedRoot); // Should print sorted numbers 1 2 3 4 5 6
    }
}
