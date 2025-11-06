import java.util.*;

class Solution {

    // 🔁 Recursive helper to build combinations
    public static void helper(int i, int target, int[] arr, List<Integer> temp, List<List<Integer>> result) {

        // 🎯 Base case 1: target achieved — valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(temp));  // add a copy of current list
            return;
        }

        // ❌ Base case 2: out of bounds or overshoot
        if (i == arr.length || target < 0) return;

        // ✅ Choice 1: take current element (allowed to reuse same element)
        temp.add(arr[i]);
        helper(i, target - arr[i], arr, temp, result); // stay at same i (reuse)
        temp.remove(temp.size() - 1); // 🟧 backtrack (undo choice)

        // 🚫 Choice 2: skip current element, move to next
        helper(i + 1, target, arr, temp, result);
    }

    // 🚀 Main function
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    // 🧪 For local testing in VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = sol.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
