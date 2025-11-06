// 🪙 LeetCode 518. Coin Change II
// Count the number of combinations to make up a given amount using infinite coins.

import java.util.*;

class Solution {

    // ---------------------------------------------------
    // 1️⃣ PURE RECURSION
    // ---------------------------------------------------
    // TC: O(2^n) — tries all combinations
    // SC: O(n) — recursion stack
    public int rec(int i, int target, int[] coins) {
        // Base case: if only one coin available
        if (i == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        // Not take current coin
        int notTake = rec(i - 1, target, coins);

        // Take current coin (stay at i, since infinite supply)
        int take = 0;
        if (coins[i] <= target)
            take = rec(i, target - coins[i], coins);

        return take + notTake;
    }


    // ---------------------------------------------------
    // 2️⃣ MEMOIZATION (Top-Down DP)
    // ---------------------------------------------------
    // TC: O(n * amount)
    // SC: O(n * amount) + O(n) recursion stack
    public int memo(int i, int target, int[] coins, int[][] dp) {
        if (i == 0)
            return (target % coins[0] == 0) ? 1 : 0;

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = memo(i - 1, target, coins, dp);
        int take = 0;
        if (coins[i] <= target)
            take = memo(i, target - coins[i], coins, dp);

        return dp[i][target] = take + notTake;
    }


    // ---------------------------------------------------
    // 3️⃣ TABULATION (Bottom-Up DP)
    // ---------------------------------------------------
    // TC: O(n * amount)
    // SC: O(n * amount)
    public int tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) dp[0][t] = 1;
            else dp[0][t] = 0;
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[i - 1][tar];
                int take = 0;
                if (coins[i] <= tar)
                    take = dp[i][tar - coins[i]];
                dp[i][tar] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }


    // ---------------------------------------------------
    // 4️⃣ SPACE OPTIMIZED
    // ---------------------------------------------------
    // TC: O(n * amount)
    // SC: O(amount)
    public int spaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        // Base case for first coin
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) prev[t] = 1;
        }

        // Compute for remaining coins
        for (int i = 1; i < n; i++) {
            int[] cur = new int[amount + 1];
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = prev[tar];
                int take = 0;
                if (coins[i] <= tar)
                    take = cur[tar - coins[i]];
                cur[tar] = take + notTake;
            }
            prev = cur;
        }

        return prev[amount];
    }


    // ---------------------------------------------------
    // MAIN FUNCTION (Use any version)
    // ---------------------------------------------------
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // 1️⃣ Recursion
        // return rec(n - 1, amount, coins);

        // 2️⃣ Memoization
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memo(n - 1, amount, coins, dp);

        // 3️⃣ Tabulation
        // return tabulation(coins, amount);

        // 4️⃣ Space Optimized
        // return spaceOptimized(coins, amount);
    }
}
