public class SearchinRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int left = 0;
        int right = arr.length - 1;
        int index = -1; // use -1 if not found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                index = mid; // ✅ found target
                break;
            }

            // ✅ Left side is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1; // search in left half
                } else {
                    left = mid + 1; // search in right half
                }
            } 
            // ✅ Right side is sorted
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1; // search in right half
                } else {
                    right = mid - 1; // search in left half
                }
            }
        }

        System.out.println(index);
    }
}
