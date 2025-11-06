class Solution {

    // -------------------- 1️⃣ RECURSION --------------------
    // TC: O(2^n)
    // SC: O(n)  (recursion stack)
    public static boolean subsetSumRec(int i, int target, int[] arr) {
        // Base cases
        if (target == 0) return true;              // subset found
        if (i == 0) return arr[0] == target;       // only one element left

        // Not take current element
        boolean notTake = subsetSumRec(i - 1, target, arr);

        // Take current element (if possible)
        boolean take = false;
        if (arr[i] <= target)
            take = subsetSumRec(i - 1, target - arr[i], arr);

        return take || notTake;
    }


    // -------------------- 2️⃣ MEMOIZATION (Top-Down DP) --------------------
    // TC: O(n * target)
    // SC: O(n * target) + O(n)  (DP array + recursion stack)
    public static boolean subsetSumMemo(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[0] == target;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean notTake = subsetSumMemo(i - 1, target, arr, dp);
        boolean take = false;
        if (arr[i] <= target)
            take = subsetSumMemo(i - 1, target - arr[i], arr, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }


    // -------------------- 3️⃣ TABULATION (Bottom-Up DP) --------------------
    // TC: O(n * target)
    // SC: O(n * target)
    public static boolean subsetSumTab(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base Case 1: target = 0 is always true
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // Base Case 2: First element
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        // Fill the table
        for (int i = 1; i < n; i++) {
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = dp[i - 1][tar];
                boolean take = false;
                if (arr[i] <= tar)
                    take = dp[i - 1][tar - arr[i]];

                dp[i][tar] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }


    // -------------------- 4️⃣ SPACE OPTIMIZED (1D DP) --------------------
    // TC: O(n * target)
    // SC: O(target)
    public static boolean subsetSumSpaceOpt(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];

        // Base case
        prev[0] = true;
        if (arr[0] <= target)
            prev[arr[0]] = true;

        // Iterate over items
        for (int i = 1; i < n; i++) {
            boolean[] cur = new boolean[target + 1];
            cur[0] = true; // base case: sum = 0 always true
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = prev[tar];
                boolean take = false;
                if (arr[i] <= tar)
                    take = prev[tar - arr[i]];
                cur[tar] = take || notTake;
            }
            prev = cur; // move current to previous
        }
        return prev[target];
    }


    // -------------------- DRIVER FUNCTION --------------------
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;

        // 1️⃣ Recursive
        // return subsetSumRec(n - 1, target, arr);

        // 2️⃣ Memoization
        // int[][] dp = new int[n][target + 1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return subsetSumMemo(n - 1, target, arr, dp);

        // 3️⃣ Tabulation
        // return subsetSumTab(arr, target);

        // 4️⃣ Space Optimized
        return subsetSumSpaceOpt(arr, target);
    }
}
