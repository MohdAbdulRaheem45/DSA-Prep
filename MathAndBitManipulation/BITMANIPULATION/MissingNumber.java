package BITMANIPULATION;

class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR all indices and numbers
        for (int i = 0; i < n; i++) {
            xor = xor ^ i ^ nums[i];
        }

        // XOR with last number (n)
        return xor ^ n;
    }
}

    

