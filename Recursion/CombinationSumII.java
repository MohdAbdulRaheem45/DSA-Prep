import java.util.*;

class Solution {
    // 🧩 Helper function for recursion + backtracking
    public static void helper(int i, int[] arr, int target, List<List<Integer>> res, List<Integer> temp) {

        // 🎯 Base case: if target becomes 0 → we found a valid combination
        if (target == 0) {
            res.add(new ArrayList<>(temp)); // add a copy of current combination
            return;
        }

        // 🌀 Try every number starting from index i
        for (int j = i; j < arr.length; j++) {

            // 🚫 Skip duplicates: if current element is same as previous one
            // and we're on the same level (j > i), skip it
            if (j > i && arr[j] == arr[j - 1]) continue;

            // ⛔ Pruning: since array is sorted, if current number > target → stop further calls
            if (arr[j] > target) return;

            // ✅ Choose current element
            temp.add(arr[j]);

            // 🔁 Recurse to next index (j + 1) → cannot reuse same element again
            helper(j + 1, arr, target - arr[j], res, temp);

            // 🔙 Backtrack: remove the last chosen element before exploring next choice
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 🔄 Sort the array to handle duplicates and allow pruning
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        // 🔁 Start recursion with index 0 and empty temp list
        helper(0, candidates, target, result, new ArrayList<>());

        return result;
    }
}
