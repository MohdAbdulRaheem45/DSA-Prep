public class P24 {//Multiply strings
    public static void main(String[] args) {
        // Two numbers as strings that we want to multiply
        String a = "123";
        String b = "456";

        // Lengths of the numbers
        int n = a.length();
        int m = b.length();

        // Array to store the result of multiplication
        // Maximum possible length is n + m
        int result[] = new int[n + m];

        // Loop over each digit of 'a' from right to left
        for (int i = n - 1; i >= 0; i--) {
            int digit1 = a.charAt(i) - '0'; // Convert char to int

            // Loop over each digit of 'b' from right to left
            for (int j = m - 1; j >= 0; j--) {
                int digit2 = b.charAt(j) - '0'; // Convert char to int

                // Multiply the digits and add any previous carry stored in result[i+j+1]
                int mul = digit1 * digit2 + result[i + j + 1];

                // Store the single digit at the current position
                result[i + j + 1] = mul % 10;

                // Carry over the remaining part to the previous position
                result[i + j] += mul / 10;
            }
        }

        // Convert the result array into a string
        StringBuilder sb = new StringBuilder();
        for (int row : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && row == 0)) {
                sb.append(row);
            }
        }

        // Print the final multiplication result
        System.out.println(sb.toString());
    }
}
