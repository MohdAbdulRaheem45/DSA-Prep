import java.util.*;

class Solution {

    // 🔁 Helper function to swap elements in the same array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ⚙️ Recursive helper function to generate all permutations
    public static void helper(int[] nums, List<List<Integer>> result, int idx) {
        // 🎯 Base case: if index reaches end, add current arrangement
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) temp.add(n); // copy current permutation
            result.add(temp);
            return;
        }

        // 🔁 Try all possibilities by swapping current index with every next element
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);              // 🟩 Choose element
            helper(nums, result, idx + 1);   // 🚀 Explore next level
            swap(nums, idx, i);              // 🟧 Undo (Backtrack)
        }
    }

    // 🚀 Main function
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0);
        return result;
    }

    // 🧪 To test in VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = sol.permute(nums);
        System.out.println(ans);
    }
}
