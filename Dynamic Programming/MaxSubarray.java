class MaxSubarray {

    // 1️⃣ Simple approach using Kadane’s Algorithm (O(n), O(1))
    public int maxSubArray(int[] nums) {
        int currSum = 0;   // current subarray sum
        int maxSum = nums[0]; // max found so far

        for (int num : nums) {
            currSum += num;              // extend subarray
            maxSum = Math.max(maxSum, currSum); // update max
            if (currSum < 0) currSum = 0; // reset if negative
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarray m = new MaxSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max Subarray Sum = " + m.maxSubArray(nums)); // 6
    }
}
