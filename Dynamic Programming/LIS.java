import java.util.*;

class Solution {

    // --------------------------------------------------------------
    // 🔹 Approach 1: O(n²) Dynamic Programming (i, j loops)
    // --------------------------------------------------------------
    /*
       Logic:
       - dp[i] = length of the longest increasing subsequence ending at index i
       - For every pair (j < i):
            if nums[i] > nums[j], then nums[i] can extend LIS ending at j
            → dp[i] = max(dp[i], dp[j] + 1)
       - Answer = max(dp[i]) over all i
       
       Time Complexity  : O(n²)
       Space Complexity : O(n)
    */
    public int lengthOfLIS_DP(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);  // every element itself is LIS of length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    // --------------------------------------------------------------
    // 🔹 Approach 2: O(n log n) Binary Search (Patience Sorting)
    // --------------------------------------------------------------
    /*
       Logic:
       - Maintain a list "temp" that stores the smallest possible tail
         of an increasing subsequence of each length.
       - For each num:
           • If num > last element of temp → append it (LIS grows)
           • Else → find index to replace using binary search (like lower_bound)
       - The size of temp = length of LIS

       Time Complexity  : O(n log n)
       Space Complexity : O(n)
    */
    public int lengthOfLIS_BinarySearch(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;  // at least one element in LIS

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                len++;
            } else {
                // find position to replace (lower_bound equivalent)
                int idx = Collections.binarySearch(temp, nums[i]);
                if (idx < 0) idx = -idx - 1;
                temp.set(idx, nums[i]);
            }
        }

        return len;
    }

    // --------------------------------------------------------------
    // 🔹 Main to test both
    // --------------------------------------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println("LIS (DP O(n²))            = " + sol.lengthOfLIS_DP(nums));
        System.out.println("LIS (Binary Search O(n log n)) = " + sol.lengthOfLIS_BinarySearch(nums));
    }
}
