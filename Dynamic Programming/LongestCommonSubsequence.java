/*
    🔥 LONGEST COMMON SUBSEQUENCE (LCS)

    Given two strings str1 and str2, find the length of their longest common subsequence.

    Example:
    Input: str1 = "abcde", str2 = "ace"
    Output: 3   ("ace")

    We’ll solve it in 4 ways:
    1️⃣ Recursion (Brute Force)
    2️⃣ Recursion + Memoization (Top-Down DP)
    3️⃣ Tabulation (Bottom-Up DP)
    4️⃣ Space Optimized (1D DP)
*/

class Solution {

    // ----------------------------------------------
    // 1️⃣ PURE RECURSION
    // ----------------------------------------------
    /*
        Time Complexity:  O(2^(n+m))   -> Exponential
        Space Complexity: O(n + m)     -> Recursion stack
    */
    public int lcsRecursion(String s1, String s2) {
        return solveRec(s1.length() - 1, s2.length() - 1, s1, s2);
    }

    private int solveRec(int i, int j, String s1, String s2) {
        // Base case: when any index goes below 0
        if (i < 0 || j < 0) return 0;

        // If characters match, take 1 + diagonal subproblem
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + solveRec(i - 1, j - 1, s1, s2);
        else
            // Else skip one char from either string
            return Math.max(solveRec(i - 1, j, s1, s2),
                            solveRec(i, j - 1, s1, s2));
    }

    // ----------------------------------------------
    // 2️⃣ MEMOIZATION (Top-Down DP)
    // ----------------------------------------------
    /*
        Time Complexity:  O(n × m)
        Space Complexity: O(n × m) + O(n + m) recursion stack
    */
    public int lcsMemoization(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];

        // Initialize dp with -1 (uncomputed)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        return solveMemo(n - 1, m - 1, s1, s2, dp);
    }

    private int solveMemo(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = 1 + solveMemo(i - 1, j - 1, s1, s2, dp);
        else
            dp[i][j] = Math.max(solveMemo(i - 1, j, s1, s2, dp),
                                solveMemo(i, j - 1, s1, s2, dp));

        return dp[i][j];
    }

    // ----------------------------------------------
    // 3️⃣ TABULATION (Bottom-Up DP)
    // ----------------------------------------------
    /*
        Time Complexity:  O(n × m)
        Space Complexity: O(n × m)
    */
    public int lcsTabulation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Base case: dp[0][*] and dp[*][0] = 0 (Java initializes to 0)

        // Build table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    // ----------------------------------------------
    // 4️⃣ SPACE OPTIMIZED (Using 1D arrays)
    // ----------------------------------------------
    /*
        Time Complexity:  O(n × m)
        Space Complexity: O(m)
    */
    public int lcsSpaceOptimized(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone(); // move current to previous
        }

        return prev[m];
    }

    // ----------------------------------------------
    // ✅ DRIVER METHOD (for testing)
    // ----------------------------------------------
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println("1️⃣ Recursion: " + obj.lcsRecursion(s1, s2));
        System.out.println("2️⃣ Memoization: " + obj.lcsMemoization(s1, s2));
        System.out.println("3️⃣ Tabulation: " + obj.lcsTabulation(s1, s2));
        System.out.println("4️⃣ Space Optimized: " + obj.lcsSpaceOptimized(s1, s2));
    }
}
