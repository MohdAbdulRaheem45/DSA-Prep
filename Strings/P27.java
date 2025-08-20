public class P27{
    public static int numDecodings(String s) {
        int n = s.length();
        // dp[i] = number of ways to decode substring starting at index i
        int[] dp = new int[n + 1];

        // Base case: empty string has 1 way (do nothing)
        dp[n] = 1;

        // Fill dp from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If current char is '0', no decoding possible → dp[i] stays 0
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // 1-digit decoding (always valid if not '0')
                dp[i] = dp[i + 1];

                // Check if we can form a valid 2-digit decoding
                if (i + 1 < n) {
                    // Take 2 characters and convert to number
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));

                    // Only numbers between 10 and 26 are valid letters
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        // Add ways of decoding the rest after taking 2 digits
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }

        // Final answer: ways to decode the whole string starting at index 0
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(numDecodings(s)); // Output: 3 ("ABC", "LC", "AW")
    }
}
