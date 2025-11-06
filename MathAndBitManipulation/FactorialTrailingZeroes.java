import java.util.*;

class Solution {
    // Function to count trailing zeroes in n! (factorial of n)
    public int trailingZeroes(int n) {
        int count = 0;

        // Each 5 in prime factorization contributes to a trailing zero
        // So count how many times 5 appears in factors of numbers from 1 to n
        while (n != 0) {
            n = n / 5;   // Every 5, 25, 125, etc. contributes extra zeros
            count += n;  // Add all multiples of 5
        }

        return count;
    }

    // Main method to test the function (for VS Code)
    public static void main(String[] args) {
       

        Solution sol = new Solution();
        int result = sol.trailingZeroes(100);

        System.out.println("Trailing zeroes in " + 100 + "! = " + result);
        
    }
}
