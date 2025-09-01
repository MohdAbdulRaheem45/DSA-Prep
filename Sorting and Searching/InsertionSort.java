public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1};
        
        // Outer loop: iterate from second element to end
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // The element to be inserted in the sorted part
            int j = i - 1;

            // Move elements of the sorted part that are greater than key one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; 
                j--; 
            }

            // Insert key at the correct position
            arr[j + 1] = key;
        }

        // Print sorted array
        for (int num : arr) {
            System.out.println(num);
        }
    }
}

