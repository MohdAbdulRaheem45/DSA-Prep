package Greedy;// 🔥 Jump Game II – Two Methods (Greedy + BFS-style)
public class JumpGameII {

    // ✅ Method 1: Greedy (Optimized O(n))
    public static int jumpGreedy(int[] nums) {
        int n = nums.length;
        int jumps = 0;        // number of jumps
        int currEnd = 0;      // current jump range
        int farthest = 0;     // farthest reachable index in current range

        // We don't need to check last index (once we reach n-1, we’re done)
        for (int i = 0; i < n - 1; i++) {

            // Track farthest we can go from current range
            farthest = Math.max(farthest, i + nums[i]);

            // If we’ve reached the end of our current jump range
            if (i == currEnd) {
                jumps++;               // make a jump
                currEnd = farthest;    // extend jump range

                // Optional optimization: stop if already at or beyond last index
                if (currEnd >= n - 1) break;
            }
        }

        return jumps;
    }

    // ✅ Method 2: BFS-style (Level by level)
    public static int jumpBFS(int[] nums) {
        int l = 0, r = 0;      // current jump range
        int jumps = 0;
        int n = nums.length;

        while (r < n - 1) {    // until we can reach or pass last index
            int farthest = 0;

            // Explore all positions within current jump range
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to the next range
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    // 🚀 Main Method for testing both versions
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Greedy Method → " + jumpGreedy(nums));  // Expected 2
        System.out.println("BFS Method → " + jumpBFS(nums));        // Expected 2

        int[] nums2 = {2, 1, 1, 1, 4};
        System.out.println("Greedy Method → " + jumpGreedy(nums2));  // Expected 3
        System.out.println("BFS Method → " + jumpBFS(nums2));        // Expected 3
    }
}
