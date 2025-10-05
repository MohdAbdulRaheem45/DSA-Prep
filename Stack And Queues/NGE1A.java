import java.util.HashMap;
import java.util.Stack;

public class NGE1A {
    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};  // Subset array
        int nums2[] = {1, 3, 4, 2}; // Main array
        int result[] = new int[nums2.length]; // To store next greater for nums2

        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop elements from stack smaller or equal to current
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }

            // If stack empty → no greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else { // Stack top is next greater
                result[i] = stack.peek();
            }

            // Push current element for future comparisons
            stack.push(nums2[i]);
        }

        // Map each element in nums2 to its next greater
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], result[i]);
        }

        // Build result for nums1 using the map
        int result2[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result2[i] = map.get(nums1[i]);
        }

        // Print final answer
        for (int num : result2) {
            System.out.println(num);
        }
    }
}
