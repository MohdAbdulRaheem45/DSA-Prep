public class RepeatingMissing {
    public static void main(String[] args) {
        int arr[] = {4, 3, 6, 2, 1, 1}; // Input array
        int n = arr.length;

        // Step 1: Calculate expected sum and sum of squares for 1..n
        int sum = 0;
        int sumSq = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;        // Expected sum of numbers 1..n
            sumSq += i * i;  // Expected sum of squares 1^2 + 2^2 + ... + n^2
        }

        // Step 2: Calculate actual sum and sum of squares from array
        int actualSum = 0;
        int actualSumSq = 0;
        for (int i = 0; i < n; i++) {
            actualSum += arr[i];           // Actual sum
            actualSumSq += arr[i] * arr[i]; // Actual sum of squares
        }

        // Step 3: Calculate differences
        int diff1 = actualSum - sum;       // R - M
        int diff2 = actualSumSq - sumSq;   // R^2 - M^2

        // Step 4: Calculate sum of R + M
        int sumRM = diff2 / diff1;         // (R^2 - M^2) / (R - M) = R + M

        // Step 5: Solve for repeating and missing
        int repeat = (diff1 + sumRM) / 2;  // R = (diff1 + (R+M))/2
        int missing = sumRM - repeat;      // M = (R+M) - R

        // Output
        System.out.println("Repeating number = " + repeat);
        System.out.println("Missing number = " + missing);
    }
}
