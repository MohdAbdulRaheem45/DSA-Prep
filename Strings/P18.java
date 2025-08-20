public class P18 {
    public static void main(String[] args) {
        // Binary strings
        String s = "01"; // decimal 1
        String k = "10"; // decimal 2

        // To store the result (we'll build it in reverse order)
        StringBuilder result = new StringBuilder();

        // Start from the rightmost bits (least significant bits)
        int i = s.length() - 1;
        int j = k.length() - 1;

        // Carry for addition
        int carry = 0;

        // Loop until both strings are processed AND no carry remains
        while (i >= 0 || j >= 0 || carry != 0) {

            // Get bit from s (or 0 if we've gone past the start)
            int bita = (i >= 0) ? s.charAt(i) - '0' : 0;

            // Get bit from k (or 0 if we've gone past the start)
            int bitb = (j >= 0) ? k.charAt(j) - '0' : 0;

            // Add bits and carry
            int sum = bita + bitb + carry;

            // The bit to append is sum % 2 (0 or 1)
            result.append(sum % 2);

            // Update carry (1 if sum >= 2, else 0)
            carry = sum / 2;

            // Move to the next bits to the left
            i--;
            j--;
        }

        // The result is in reverse order, so reverse it before printing
        System.out.println(result.reverse().toString()); // Expected output: "11"
    }
}
