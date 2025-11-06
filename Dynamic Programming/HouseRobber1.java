import java.util.Arrays;

class HouseRobber1 {

    // 1️⃣ RECURSION (Brute Force)
    // Idea: At every house, we have two choices — rob it or skip it.
    // If we rob, we add nums[i] + solve(i-2)
    // If we skip, we move to i-1
    // Time: O(2^n)
    public int solveRec(int i, int[] nums) {
        if (i < 0) return 0;          // no houses left
        if (i == 0) return nums[0];   // only one house available
        int rob = nums[i] + solveRec(i - 2, nums); // include this house
        int skip = solveRec(i - 1, nums);           // skip this house
        return Math.max(rob, skip);                 // choose the better option
    }

    public int robRec(int[] nums) {
        return solveRec(nums.length - 1, nums);
    }

    // 2️⃣ MEMOIZATION (Top-Down DP)
    // Store results of subproblems to avoid recomputation.
    // Time: O(n), Space: O(n) (stack + dp array)
    public int solveMemo(int i, int[] nums, int[] dp) {
        if (i < 0) return 0;
        if (i == 0) return nums[0];
        if (dp[i] != -1) return dp[i]; // already solved
        int rob = nums[i] + solveMemo(i - 2, nums, dp);
        int skip = solveMemo(i - 1, nums, dp);
        return dp[i] = Math.max(rob, skip);
    }

    public int robMemo(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveMemo(nums.length - 1, nums, dp);
    }

    // 3️⃣ TABULATION (Bottom-Up DP)
    // Build dp[] iteratively.
    // dp[i] = max(rob current house + dp[i-2], skip current (dp[i-1]))
    // Time: O(n), Space: O(n)
    public int robTab(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    // 4️⃣ SPACE OPTIMIZED
    // Instead of keeping whole dp[], keep only last two results.
    // Time: O(n), Space: O(1)
    public int robSpaceOpt(int[] nums) {
       int n = nums.length;

        // Base case: if there’s only one house
        if (n == 1) return nums[0];

        // prev2 = dp[i-2], prev = dp[i-1]
        int prev2 = nums[0]; // best if we only consider house 0
        int prev = Math.max(nums[0], nums[1]); // best if we consider first 2 houses

        // Start from 3rd house (index 2)
        for (int i = 2; i < n; i++) {
            // If we rob current house, add nums[i] + prev2
            // If we skip, keep prev
            int curr = Math.max(prev2 + nums[i], prev);

            // Move the window forward
            prev2 = prev;
            prev = curr;
        }

        // prev now stores max money till last house
        return prev;
    }

    // Main to test all methods
    public static void main(String[] args) {
        HouseRobber1 h = new HouseRobber1();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Recursive: " + h.robRec(nums));
        System.out.println("Memoization: " + h.robMemo(nums));
        System.out.println("Tabulation: " + h.robTab(nums));
        System.out.println("Space Optimized: " + h.robSpaceOpt(nums));
    }
}
