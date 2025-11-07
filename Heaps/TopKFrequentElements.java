import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            // If num exists, increment count; else start with 1
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap based on frequency
        // The heap will store numbers, smallest frequency at root
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b) // compare frequency
        );

        // Step 3: Maintain a heap of size k
        for (int num : freqMap.keySet()) {
            minHeap.add(num);            // add number to heap
            if (minHeap.size() > k) {    // if heap size exceeds k
                minHeap.poll();          // remove number with smallest frequency
            }
        }

        // Step 4: Extract elements from heap into result array
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll(); // smallest freq in heap removed first
        }

        return result; // contains k most frequent elements
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Should print [1, 2] because 1 occurs 3 times, 2 occurs 2 times
        System.out.println(Arrays.toString(sol.topKFrequent(nums, k)));
    }
}
