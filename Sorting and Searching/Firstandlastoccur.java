public class Firstandlastoccur {

    // Helper function: find index of first or last occurrence
    private static int findIndex(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (findFirst) {
                    // go left to find first occurrence
                    right = mid - 1;
                } else {
                    // go right to find last occurrence
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);   // find first occurrence
        int last = findIndex(nums, target, false);  // find last occurrence
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] ans = searchRange(arr, target);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }
}
