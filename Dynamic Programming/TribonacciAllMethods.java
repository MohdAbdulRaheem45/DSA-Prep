public class TribonacciAllMethods {

    // 1️⃣ Recursion (Exponential, O(3^n))
    public static int tribonacciRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacciRecursive(n - 1) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 3);
    }

    // 2️⃣ Memoization (Top-Down DP)
    public static int tribonacciMemo(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        return tribonacciMemoHelper(n, memo);
    }

    private static int tribonacciMemoHelper(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = tribonacciMemoHelper(n - 1, memo) + tribonacciMemoHelper(n - 2, memo) + tribonacciMemoHelper(n - 3, memo);
        return memo[n];
    }

    // 3️⃣ Tabulation (Bottom-Up DP)
    public static int tribonacciTab(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // 4️⃣ Space Optimized (O(1) space)
    public static int tribonacciSpaceOpt(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1, curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = curr;
        }
        return t2;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Tribonacci with n = " + n);
        System.out.println("Recursive: " + tribonacciRecursive(n));
        System.out.println("Memoization: " + tribonacciMemo(n));
        System.out.println("Tabulation: " + tribonacciTab(n));
        System.out.println("Space Optimized: " + tribonacciSpaceOpt(n));
    }
}
