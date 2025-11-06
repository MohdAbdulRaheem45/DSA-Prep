// LeetCode 494: Target Sum
// Convert problem into subset sum count problem
// Formula: sum(S1) = (totalSum + target) / 2

import java.util.*;

class Solution {

    // -------------------------------------------------------------
    // 1️⃣ Recursive + Memoization approach
    // -------------------------------------------------------------
    public int countMemo(int i, int target, int[] nums, int[][] dp) {
        // Base cases
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2; // two ways (pick or not pick)
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = countMemo(i - 1, target, nums, dp);
        int take = 0;
        if (nums[i] <= target) take = countMemo(i - 1, target - nums[i], nums, dp);

        return dp[i][target] = take + notTake;
    }

    // -------------------------------------------------------------
    // 2️⃣ Tabulation approach (bottom-up)
    // -------------------------------------------------------------
    public int countTab(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Base initialization
        if (nums[0] == 0) dp[0][0] = 2;  // two ways: pick or not pick zero
        else dp[0][0] = 1;               // one way: don't pick

        if (nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;

        // Build table
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (nums[i] <= t) take = dp[i - 1][t - nums[i]];
                dp[i][t] = take + notTake;
            }
        }
        return dp[n - 1][target];
    }

    // -------------------------------------------------------------
    // 3️⃣ Space Optimized approach (1D DP)
    // -------------------------------------------------------------
    public int countSpaceOpt(int[] nums, int target) {
        int n = nums.length;
        int[] prev = new int[target + 1];

        if (nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (nums[0] != 0 && nums[0] <= target)
            prev[nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            for (int t = 0; t <= target; t++) {
                int notTake = prev[t];
                int take = 0;
                if (nums[i] <= t) take = prev[t - nums[i]];
                curr[t] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    // -------------------------------------------------------------
    // Main method: handles conversion from target sum → subset sum
    // -------------------------------------------------------------
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Invalid case
        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0)
            return 0;

        int subsetSum = (totalSum + target) / 2;
        int n = nums.length;

        // --- Choose any one approach ---
        // 1. Memoization
        int[][] dp = new int[n][subsetSum + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return countMemo(n - 1, subsetSum, nums, dp);

        // 2. Tabulation
        // return countTab(nums, subsetSum);

        // 3. Space Optimized
        return countSpaceOpt(nums, subsetSum);
    }
}

/*
-------------------------------------------------------------
Time and Space Complexities:
-------------------------------------------------------------

1️⃣ Recursion + Memoization:
   Time: O(n * target)
   Space: O(n * target) + O(n) recursion stack

2️⃣ Tabulation:
   Time: O(n * target)
   Space: O(n * target)

3️⃣ Space Optimized:
   Time: O(n * target)
   Space: O(target)
-------------------------------------------------------------
*/
