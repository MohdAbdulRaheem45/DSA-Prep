import java.util.Arrays;

class HouseRobber2 {

    // Helper for linear version (same as House Robber I space optimized)
    private int robLinear(int[] nums) {
        int n = nums.length;
        int prev2 = 0, prev1 = 0;

        for (int num : nums) {
            int curr = Math.max(prev1, num + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Main for circular street
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: exclude last
        int[] case1 = Arrays.copyOfRange(nums, 0, n - 1);
        // Case 2: exclude first
        int[] case2 = Arrays.copyOfRange(nums, 1, n);
        //we can save the space by just call like this Math.max(rob(0,n-2),rob(1,n-1))

        return Math.max(robLinear(case1), robLinear(case2));
    }

    public static void main(String[] args) {
        HouseRobber2 h = new HouseRobber2();
        int[] nums = {2, 3, 2};
        System.out.println("Max money (circular): " + h.rob(nums)); // Output: 3
    }
}
