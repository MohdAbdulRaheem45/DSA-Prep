import java.util.*;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Step 0: Min-heap to always get the smallest node among current candidates
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val // compare nodes by their value
        );

        // Step 1: Add all non-null heads of the k lists to the heap
        // Only the head of each list is added initially
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
                // Example: lists = [[1,4,5],[1,3,4],[2,6]]
                // After this loop, heap contains: 1 (from list0), 1 (from list1), 2 (from list2)
            }
        }

        // Step 2: Dummy head to simplify list construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 3: Extract smallest node and add its next node if it exists
        while (!minHeap.isEmpty()) {
            // Get the smallest node from heap
            ListNode smallest = minHeap.poll(); // root of min-heap

            // Append it to the result list
            tail.next = smallest;
            tail = tail.next;

            // If the extracted node has a next node, add that next node to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
                // This ensures heap always contains the next smallest candidates from each list
            }

            // At any point, heap size <= k (number of lists)
        }

        // Step 4: Return merged list (skip dummy head)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        Solution sol = new Solution();
        ListNode merged = sol.mergeKLists(lists);

        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Output: 1 1 2 3 4 4 5 6
    }
}
