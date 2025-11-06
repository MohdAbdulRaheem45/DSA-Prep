import java.util.*;

class Solution {

    // Function to compute x raised to power n (x^n)
    public double myPow(double x, int n) {
        // Base case: any number raised to 0 is 1
        if (n == 0) return 1.0;

        // Use long to avoid overflow if n = Integer.MIN_VALUE
        long power = n;

        // Handle negative exponent:
        // x^-n = (1/x)^n
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1.0; // result variable

        // Loop through bits of power (binary exponentiation)
        while (power > 0) {
            // If the last bit of power is 1 (odd number)
            // then multiply the current x to result
            if ((power & 1) == 1) {
                ans *= x;
            }

            // Square x for the next bit
            // (because each bit represents power of two)
            x = x * x;

            // Move to the next bit (right shift)
            power >>= 1; // same as power = power / 2
        }

        // Return the final computed result
        return ans;
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();

        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        double result = sol.myPow(x, n);

        System.out.println(x + "^" + n + " = " + result);

        sc.close();
    }
}
