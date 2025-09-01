public class MergeSort {

    // Main Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        // Base case: if the array has more than one element
        if (left < right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // Recursively sort the left half
            mergeSort(arr, left, mid);

            // Recursively sort the right half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays arr[left..mid] and arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;    // Size of right subarray

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function to test Merge Sort
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1};
        System.out.println("Original Array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
