class Solution {
    // Helper function to check if any subset sums to target
    public static boolean sum(int arr[], int target) {
        int n = arr.length;
        boolean prev[] = new boolean[target + 1];

        // Base case: sum = 0 is always possible
        prev[0] = true;

        // Base case: first element
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        // Build up for each element
        for (int i = 1; i < n; i++) {
            boolean curr[] = new boolean[target + 1];
            curr[0] = true; // sum 0 always possible

            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = prev[tar];
                boolean take = false;
                if (arr[i] <= tar)
                    take = prev[tar - arr[i]];

                curr[tar] = take || notTake;
            }

            prev = curr; // move to next iteration
        }

        return prev[target];
    }

    // Main function to check if array can be partitioned into equal subsets
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        // If total sum is odd, cannot split equally
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        return sum(nums, target);
    }
}
