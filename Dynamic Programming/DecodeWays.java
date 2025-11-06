// 💡 Decode Ways – All Approaches (Recursion, Memoization, Tabulation, Space Optimization)

public class DecodeWays {

    // 🔹 1. Recursion (Exponential TC)
    public int decodeRec(String s, int i) {
        // Base: reached end → 1 valid decoding
        if (i == s.length()) return 1;
        // If starts with '0', can't decode
        if (s.charAt(i) == '0') return 0;

        // Take one character
        int ways = decodeRec(s, i + 1);

        // Take two characters if valid (<= 26)
        if (i + 1 < s.length()) {
            int val = Integer.valueOf(s.substring(i, i + 2));
            if (val <= 26) {
                ways += decodeRec(s, i + 2);
            }
        }

        return ways;
    }

    // 🔹 2. Memoization (Top-Down)
    public int decodeMemo(String s, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int ways = decodeMemo(s, i + 1, dp);
        if (i + 1 < s.length()) {
            int val = Integer.valueOf(s.substring(i, i + 2));
            if (val <= 26) {
                ways += decodeMemo(s, i + 2, dp);
            }
        }

        return dp[i] = ways;
    }

    // 🔹 3. Tabulation (Bottom-Up)
    public int decodeTab(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1; // empty string = 1 way
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) dp[i] += dp[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    // 🔹 4. Space Optimization (O(1) space)
    public int decodeSpaceOpt(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int prev2 = 1;
        int prev1 = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int curr = 0;
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) curr += prev1;
            if (twoDigit >= 10 && twoDigit <= 26) curr += prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // 🔹 Main function to test all methods
    public static void main(String[] args) {
        DecodeWays sol = new DecodeWays();
        String s = "226";

        // Recursion
        System.out.println("Recursion → " + sol.decodeRec(s, 0));

        // Memoization
        int[] dp = new int[s.length()];
        java.util.Arrays.fill(dp, -1);
        System.out.println("Memoization → " + sol.decodeMemo(s, 0, dp));

        // Tabulation
        System.out.println("Tabulation → " + sol.decodeTab(s));

        // Space Optimized
        System.out.println("Space Optimized → " + sol.decodeSpaceOpt(s));
    }
}
