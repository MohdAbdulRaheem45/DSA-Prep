public class FibonacciNumber {

    // 1️⃣ Simple Recursion — Exponential time O(2^n)
    // Very slow for large n because it recomputes values repeatedly.
    public static int fibRecursive(int n) {
        if (n <= 1) return n; // base case: fib(0)=0, fib(1)=1
        return fibRecursive(n - 1) + fibRecursive(n - 2); // recursive calls
    }

    // 2️⃣ Memoization (Top-Down Dynamic Programming)
    // Uses an array to store computed results and avoid recomputation.
    // Time: O(n), Space: O(n) for memo + recursion stack
    public static int fibMemo(int n) {
        int[] memo = new int[n + 1]; // memo[i] will store fib(i)
        for (int i = 0; i <= n; i++) memo[i] = -1; // mark as uncomputed
        return fibMemoHelper(n, memo);
    }

    private static int fibMemoHelper(int n, int[] memo) {
        if (n <= 1) return n; // base case
        if (memo[n] != -1) return memo[n]; // if already computed
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo); // store result
        return memo[n];
    }

    // 3️⃣ Tabulation (Bottom-Up Dynamic Programming)
    // Builds the result iteratively from base cases.
    // Time: O(n), Space: O(n)
    public static int fibTabulation(int n) {
        if (n <= 1) return n; // base case
        int[] dp = new int[n + 1]; // dp[i] = fib(i)
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // fill table iteratively
        }
        return dp[n]; // final answer
    }

    // 4️⃣ Space Optimized Version
    // Only stores last two Fibonacci values instead of the whole array.
    // Time: O(n), Space: O(1)
    public static int fibSpaceOptimized(int n) {
        if (n <= 1) return n; // base case
        int prev2 = 0; // fib(0)
        int prev1 = 1; // fib(1)
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev1 + prev2; // current fib value
            prev2 = prev1; // shift for next iteration
            prev1 = cur;
        }
        return cur;
    }

    // 5️⃣ Helper function to print first N Fibonacci numbers from each method
    public static void printFirstNFibs(int count) {
        System.out.println("n : Recursion | Memo | Tabulation | SpaceOpt");
        for (int i = 0; i < count; i++) {
            int r = (i <= 20) ? fibRecursive(i) : -1; // limit recursion for speed
            int m = fibMemo(i);
            int t = fibTabulation(i);
            int s = fibSpaceOptimized(i);
            String recStr = (r == -1) ? "(skip)" : Integer.toString(r);
            System.out.printf("%2d : %8s | %4d | %9d | %8d%n", i, recStr, m, t, s);
        }
    }

    // 6️⃣ Main method — entry point
    public static void main(String[] args) {
        int n = 10; // example input

        // Printing results of all four approaches
        System.out.println("fibRecursive(" + n + ") = " + fibRecursive(n));
        System.out.println("fibMemo(" + n + ") = " + fibMemo(n));
        System.out.println("fibTabulation(" + n + ") = " + fibTabulation(n));
        System.out.println("fibSpaceOptimized(" + n + ") = " + fibSpaceOptimized(n));

        // Print comparison table
        System.out.println("\nFirst 12 Fibonacci numbers from each method (recursion skipped for larger i):\n");
        printFirstNFibs(5);
    }
}
