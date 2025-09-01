public class InversionCount {

    // Function to count inversions in an array
    public static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions while merging two halves
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Merge two sorted halves and count cross inversions
    public static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        // Copy right half
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        int inversions = 0;

        // Merge L and R back into arr
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                // All remaining elements in L are greater than R[j]
                inversions += (n1 - i);
            }
        }

        // Copy remaining elements
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];

        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int inversionCount = mergeSortAndCount(arr, 0, arr.length - 1);
        System.out.println("Number of inversions: " + inversionCount);
    }
}

