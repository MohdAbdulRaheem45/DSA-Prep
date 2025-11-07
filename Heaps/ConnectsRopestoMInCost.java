import java.util.*;

class Solution {
    public int minCost(int[] ropes) {
        // Step 1: Add all ropes to a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Step 2: Combine ropes until one remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // smallest rope
            int second = minHeap.poll(); // second smallest

            int cost = first + second;
            totalCost += cost;

            // Push combined rope back into heap
            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ropes = {4, 3, 2, 6};
        System.out.println(sol.minCost(ropes)); // Output: 29
    }
}
