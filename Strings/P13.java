public class P13 {
    public static String countAndSay(int n) {
        if (n == 1) return "1"; // Base case

        String result = "1"; // Starting with 1

        // Start from 2 to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            // Loop through the previous result
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++; // Count same digits
                } else {
                    // Say the count and the digit
                    sb.append(count);         // e.g., 2
                    sb.append(result.charAt(j - 1)); // e.g., 1
                    count = 1; // Reset count
                }
            }

            // Add last counted digit
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString(); // Update result
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("n = " + i + " → " + countAndSay(i));
        }
    }
}
