package Greedy;
public class JumpGameI {
    public static boolean jump(int[] arr) {
        int farthestidx = 0; // farthest reachable index so far

        for (int i = 0; i < arr.length; i++) {

            // ❌ If current index is beyond what we can reach, we’re stuck
            if (i > farthestidx) return false;

            // ✅ Update farthest index we can reach from here
            farthestidx = Math.max(farthestidx, i + arr[i]);

            // 🚀 If we can reach or go beyond the last index, return true
            if (farthestidx >= arr.length - 1) return true;
        }

        // ✅ Finished loop without getting stuck → reachable
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};   // Can reach → true
        System.out.println(jump(arr));

        int arr2[] = {1, 2, 0, 0, 0};  // Can’t reach last index → false
        System.out.println(jump(arr2));
    }
}
