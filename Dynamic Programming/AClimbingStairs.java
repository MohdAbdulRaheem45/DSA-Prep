public class AClimbingStairs {

    // 1️⃣ Recursion (Exponential time, O(2^n))
    public static int climbStairsRecursive(int n) {
        if (n <= 1) return 1; // 1 way to reach step 0 or 1
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    // 2️⃣ Memoization (Top-Down DP, O(n))
    public static int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        return climbStairsMemoHelper(n, memo);
    }

    private static int climbStairsMemoHelper(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = climbStairsMemoHelper(n - 1, memo) + climbStairsMemoHelper(n - 2, memo);
        return memo[n];
    }

    // 3️⃣ Tabulation (Bottom-Up DP, O(n) time & space)
    public static int climbStairsTab(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4️⃣ Space Optimized (O(n) time, O(1) space)
    public static int climbStairsSpaceOpt(int n) {
        if (n <= 1) return 1;
        int prev2 = 1; // ways to reach step 0
        int prev1 = 1; // ways to reach step 1
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Climbing Stairs with n = " + n);
        System.out.println("Recursive: " + climbStairsRecursive(n));
        System.out.println("Memoization: " + climbStairsMemo(n));
        System.out.println("Tabulation: " + climbStairsTab(n));
        System.out.println("Space Optimized: " + climbStairsSpaceOpt(n));
    }
}
