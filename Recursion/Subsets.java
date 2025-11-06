// 🌟 LeetCode 78 – Subsets
// Generate all possible subsets (the power set) of a given array.

import java.util.*;

class Solution {

    // Recursive helper to build subsets
    public static void generate(int[] nums, int index, 
                                List<Integer> temp, 
                                List<List<Integer>> result) {
        // 🧱 Base case: reached end → store the current subset
        if (index == nums.length) {
            result.add(new ArrayList<>(temp)); // make a copy before adding
            return;
        }

        // 🟩 Choice 1: include current element
        temp.add(nums[index]);
        generate(nums, index + 1, temp, result);

        // 🟧 Choice 2: exclude current element (backtrack)
        temp.remove(temp.size() - 1);
        generate(nums, index + 1, temp, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // 🧪 Local test (for VS Code)
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = sol.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : ans) {
            System.out.println(subset);
        }
    }
}
