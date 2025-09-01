public class AllocatePages {
    // Check if allocation possible with given mid (max pages allowed per student)
    public static boolean isValid(int[] arr, int m, int mid) {
        int student = 1;  // start with first student
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            // If a single book > mid → not possible
            if (arr[i] > mid) return false;

            if (pages + arr[i] <= mid) {
                // Allocate book to current student
                pages += arr[i];
            } else {
                // Need a new student
                student++;
                pages = arr[i];

                if (student > m) return false; // more students needed
            }
        }
        return true; // allocation successful
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        int m = 2;

        int left = 0, right = 0, ans = -1;

        // Right = sum of all pages
        for (int num : arr) {
            right += num;
          // Left = largest single book
        }

        // Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, m, mid)) {
                ans = mid;
                right = mid - 1; // try to minimize
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Minimum possible max pages = " + ans);
    }
}
