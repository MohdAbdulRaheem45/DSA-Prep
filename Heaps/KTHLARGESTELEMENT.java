import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse through all numbers
        for (int num : nums) {
            minHeap.add(num); // Add current number to the heap

            // If heap size exceeds k, remove the smallest element
            // This ensures the heap always contains only the k largest elements
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove root (smallest among the heap)
            }
        }

        // After processing all numbers, the root of the heap is the kth largest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println("The " + k + "th largest element is: " + sol.findKthLargest(nums, k));
        // Output: 4
    }
}
