public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1};
        int n = arr.length;

        // Outer loop for each position in the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume current index has the minimum value

            // Find the minimum element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the current position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // Print sorted array
        for (int num : arr) {
            System.out.println(num);
        }
    }
}

