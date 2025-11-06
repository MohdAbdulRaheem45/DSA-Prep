package BITMANIPULATION;

class Solution {
    public int hammingWeight(int n) {
        int c = 0;              // count of set bits
        while (n != 0) {        // until all bits are checked
            if ((n & 1) == 1) { // check if last bit (LSB) is 1
                c++;            // increment count
            }
            n >>= 1;            // right shift n (drop last bit)
        }
        return c;               // return total 1 bits
    }


public int hammingWeight2(int n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1); // removes the lowest set bit
        count++;
    }
    return count;
}
}