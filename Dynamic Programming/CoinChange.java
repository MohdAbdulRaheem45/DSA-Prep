// 🪙 LeetCode 322. Coin Change
// Goal: Find minimum number of coins to make 'amount' using infinite supply of given coins.

class Solution {

    // ---------------------------------------------
    // 1️⃣ PURE RECURSION (Exponential)
    // ---------------------------------------------
    // TC: O(2^n) — tries all combinations
    // SC: O(n) — recursion stack depth
    public int rec(int i, int target, int[] coins) {
        if (i == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int) 1e9; // impossible case
        }

        int notTake = rec(i - 1, target, coins);
        int take = (int) 1e9;
        if (coins[i] <= target)
            take = 1 + rec(i, target - coins[i], coins); // same index since infinite coins

        return Math.min(take, notTake);
    }


    // ---------------------------------------------
    // 2️⃣ MEMOIZATION (Top-Down DP)
    // ---------------------------------------------
    // TC: O(n * amount)
    // SC: O(n * amount) + O(n) recursion stack
    public int memo(int i, int target, int[] coins, int[][] dp) {
        if (i == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int) 1e9;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = memo(i - 1, target, coins, dp);
        int take = (int) 1e9;
        if (coins[i] <= target)
            take = 1 + memo(i, target - coins[i], coins, dp);

        return dp[i][target] = Math.min(take, notTake);
    }


    // ---------------------------------------------
    // 3️⃣ TABULATION (Bottom-Up DP)
    // ---------------------------------------------
    // TC: O(n * amount)
    // SC: O(n * amount)
    public int tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) dp[0][t] = t / coins[0];
            else dp[0][t] = (int) 1e9;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];
                int take = (int) 1e9;
                if (coins[i] <= t)
                    take = 1 + dp[i][t - coins[i]];
                dp[i][t] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];
        return (ans >= 1e9) ? -1 : ans;
    }


    // ---------------------------------------------
    // 4️⃣ SPACE OPTIMIZED DP
    // ---------------------------------------------
    // TC: O(n * amount)
    // SC: O(amount)
    public int spaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];

        // Base case
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) prev[t] = t / coins[0];
            else prev[t] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = prev[t];
                int take = (int) 1e9;
                if (coins[i] <= t)
                    take = 1 + cur[t - coins[i]]; // use current row
                cur[t] = Math.min(take, notTake);
            }
            prev = cur.clone();
        }

        int ans = prev[amount];
        return (ans >= 1e9) ? -1 : ans;
    }


    // ---------------------------------------------
    // MAIN FUNCTION (You can test each version)
    // ---------------------------------------------
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // ✅ Uncomment the version you want to use:

        // 1. Recursive
        // int ans = rec(n - 1, amount, coins);

        // 2. Memoization
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);
        int ans = memo(n - 1, amount, coins, dp);

        // 3. Tabulation
        // int ans = tabulation(coins, amount);

        // 4. Space Optimized
        // int ans = spaceOptimized(coins, amount);

        return (ans >= 1e9) ? -1 : ans;
    }
}
