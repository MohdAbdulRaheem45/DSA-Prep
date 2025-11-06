// 💡 Problem: Edit Distance (Levenshtein Distance)
// Given two strings word1 and word2, find the minimum number of operations 
// (insert, delete, replace) required to convert word1 to word2.

class Solution {

    /*--------------------------------------------------------------
      🔹 1. PURE RECURSION
      --------------------------------------------------------------*/
    public int recursion(String s1, String s2, int i, int j) {
        // Base cases
        if (i < 0) return j + 1; // Need to insert all remaining chars of s2
        if (j < 0) return i + 1; // Need to delete all remaining chars of s1

        // If characters match → move diagonally
        if (s1.charAt(i) == s2.charAt(j))
            return recursion(s1, s2, i - 1, j - 1);

        // Else → try Insert, Delete, Replace and take min
        int insert = 1 + recursion(s1, s2, i, j - 1);
        int delete = 1 + recursion(s1, s2, i - 1, j);
        int replace = 1 + recursion(s1, s2, i - 1, j - 1);

        return Math.min(insert, Math.min(delete, replace));
    }

    /* 
       ⏱️ Time Complexity: O(3^(n+m)) — exponential
       💾 Space Complexity: O(n+m) — recursion stack
    */


    /*--------------------------------------------------------------
      🔹 2. MEMOIZATION (Top-Down DP)
      --------------------------------------------------------------*/
    public int memo(String s1, String s2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        // If characters match
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = memo(s1, s2, i - 1, j - 1, dp);

        // Else → insert, delete, replace
        int insert = 1 + memo(s1, s2, i, j - 1, dp);
        int delete = 1 + memo(s1, s2, i - 1, j, dp);
        int replace = 1 + memo(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    /* 
       ⏱️ Time Complexity: O(n * m)
       💾 Space Complexity: O(n * m) + O(n + m)
          → dp array + recursion stack
    */


    /*--------------------------------------------------------------
      🔹 3. TABULATION (Bottom-Up DP)
      --------------------------------------------------------------*/
    public int tabulation(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Base cases
        for (int i = 0; i <= n; i++) dp[i][0] = i; // delete all
        for (int j = 0; j <= m; j++) dp[0][j] = j; // insert all

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    /* 
       ⏱️ Time Complexity: O(n * m)
       💾 Space Complexity: O(n * m)
    */


    /*--------------------------------------------------------------
      🔹 4. SPACE OPTIMIZED (Using two 1D arrays)
      --------------------------------------------------------------*/
    public int spaceOptimized(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Base case for first row
        for (int j = 0; j <= m; j++) prev[j] = j;

        for (int i = 1; i <= n; i++) {
            cur[0] = i; // base case for current row
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[j] = prev[j - 1];
                else {
                    int insert = 1 + cur[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    cur[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = cur.clone(); // move current row to previous
        }

        return prev[m];
    }

    /* 
       ⏱️ Time Complexity: O(n * m)
       💾 Space Complexity: O(m)
    */


    /*--------------------------------------------------------------
      🧠 MAIN DRIVER FUNCTION
      --------------------------------------------------------------*/
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        // 🔹 1. Recursion
        // return recursion(word1, word2, n - 1, m - 1);

        // 🔹 2. Memoization
        // int[][] dp = new int[n][m];
        // for (int[] row : dp) java.util.Arrays.fill(row, -1);
        // return memo(word1, word2, n - 1, m - 1, dp);

        // 🔹 3. Tabulation
        // return tabulation(word1, word2);

        // 🔹 4. Space Optimized
        return spaceOptimized(word1, word2);
    }
}

/*
--------------------------------------------------------------
🔹 Summary of All Methods
--------------------------------------------------------------
| Method           | Time Complexity | Space Complexity     |
|------------------|-----------------|----------------------|
| Recursion        | O(3^(n+m))      | O(n + m)             |
| Memoization      | O(n * m)        | O(n * m) + O(n + m)  |
| Tabulation       | O(n * m)        | O(n * m)             |
| Space Optimized  | O(n * m)        | O(m)                 |
--------------------------------------------------------------
*/
