class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // Initialize result with the first element
        int res = nums[0];

        // Left and right running products
        int leftProd = 1;
        int rightProd = 1;

        for (int i = 0; i < n; i++) {

            // ✅ Reset before multiplying if previous product was zero
            // because a zero breaks the subarray product chain.
            leftProd = (leftProd == 0) ? 1 : leftProd;
            rightProd = (rightProd == 0) ? 1 : rightProd;

            // Multiply from both ends
            leftProd *= nums[i];             // product from left → right
            rightProd *= nums[n - 1 - i];    // product from right → left

            // Update maximum result
            res = Math.max(res, Math.max(leftProd, rightProd));
        }

        return res;
    }
}
