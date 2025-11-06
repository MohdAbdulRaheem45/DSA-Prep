import java.util.*;

class Solution {
    public int countPrimes(int n) {
        // If n is 0 or 1, there are no prime numbers less than n
        if (n == 0 || n == 1) return 0;

        // Create a boolean array where each index represents whether that number is prime
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially

        // 0 and 1 are not prime numbers
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes algorithm
        // Loop through all numbers up to √n
        for (int i = 2; i * i < n; i++) {
            // If i is still marked as prime
            if (isPrime[i]) {
                // Mark all multiples of i (starting from i*i) as not prime
                // Because smaller multiples would have been marked by smaller primes
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count all numbers that are still marked as prime
        int count = 0;
        for (boolean s : isPrime) {
            if (s) count++;
        }

        // Return the total count of primes less than n
        return count;
    }
}
