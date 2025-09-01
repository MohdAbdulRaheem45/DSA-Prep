public class FindMinRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        int left = 0;
        int right = arr.length - 1;
        int min = arr[0]; // keep track of minimum

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Case 1: If array is already sorted in this range
            if (arr[left] <= arr[right]) {
                min = Math.min(min, arr[left]); // leftmost is the smallest
                break; // ✅ sorted, no need to continue
            }

            // Case 2: Left part is sorted
            if (arr[left] <= arr[mid]) {
                min = Math.min(min, arr[left]); // leftmost might be the min
                left = mid + 1; // search right half
            }
            // Case 3: Right part is sorted
            else {
                min = Math.min(min, arr[mid]); // mid could be the min
                right = mid - 1; // search left half
            }
        }

        System.out.println("Minimum element = " + min);
    }
}
