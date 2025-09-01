import java.util.Arrays;

public class AggresiveCows {
    // Check if we can place c cows with at least 'mid' distance
    public static boolean isValid(int[] stalls, int c, int mid) {
        int lastpos = stalls[0]; // place first cow at first stall
        int count = 1;           // already placed 1 cow

        for (int i = 1; i < stalls.length; i++) {
            if ((stalls[i] - lastpos) >= mid) {
                count++;
                lastpos = stalls[i];
            }
            if (count == c) return true; // all cows placed
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 4, 9};
        int c = 3;
        int ans = -1;

        Arrays.sort(arr); // sort stalls first
        int left = 1;
        int right = arr[arr.length - 1] - arr[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, c, mid)) {
                ans = mid;      // mid is possible, try bigger
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
