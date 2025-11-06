// User function Template for Java

import java.util.*;

class Solution {

    // ---------------------------------------------------------
    // 1️⃣ TABULATION (Bottom-Up DP)
    // ---------------------------------------------------------
    /*
        Time Complexity:  O(n × m)
        Space Complexity: O(n × m)
    */
    public int longestCommonSubstrTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int len = 0;

        // dp[i][j] = length of longest common substring ending at s1[i-1], s2[j-1]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    len = Math.max(len, dp[i][j]);
                } else {
                    dp[i][j] = 0; // substring breaks if mismatch
                }
            }
        }

        return len;
    }

    // ---------------------------------------------------------
    // 2️⃣ SPACE OPTIMIZED VERSION (1D Arrays)
    // ---------------------------------------------------------
    /*
        Time Complexity:  O(n × m)
        Space Complexity: O(m)
    */
    public int longestCommonSubstrSpaceOpt(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        int len = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    len = Math.max(len, cur[j]);
                } else {
                    cur[j] = 0; // reset when mismatch
                }
            }
            prev = cur.clone();      // move current row to prev
            Arrays.fill(cur, 0);     // reset current row
        }

        return len;
    }

    // ---------------------------------------------------------
    // ✅ MAIN METHOD (for quick testing)
    // ---------------------------------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abcde";
        String s2 = "abfce";

        System.out.println("Tabulation LCS length: " + sol.longestCommonSubstrTabulation(s1, s2));
        System.out.println("Space Optimized LCS length: " + sol.longestCommonSubstrSpaceOpt(s1, s2));
    }
}
