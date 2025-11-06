package BITMANIPULATION;

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Negative numbers and 0 are not powers of 2
        if (n <= 0) return false;

        // True only if n has exactly one bit set
        return (n & (n - 1)) == 0;
    }

    // Quick test in VS Code
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " -> " + s.isPowerOfTwo(i));
        }
    }
}

