package BITMANIPULATION;

class Solution {
    // Function to reverse bits of a 32-bit integer
    public int reverseBits(int n) {
        int rev = 0; // stores reversed bits

        for (int i = 0; i < 32; i++) {   // iterate 32 times for each bit
            rev <<= 1;                   // shift left to make room for next bit
            rev |= (n & 1);              // add the last bit of n to rev
            n >>= 1;                     // shift n right (drop last bit)
        }

        return rev;
    }

    // ✅ For VS Code testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 0b00000010100101000001111010011100;
        System.out.println(sol.reverseBits(n)); // Output: 964176192
    }
}

    

