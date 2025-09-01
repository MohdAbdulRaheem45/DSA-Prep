public class KthElementTwoSorted {

    public static int kthElement(int arr1[], int arr2[], int k) {
        int m = arr1.length;
        int n = arr2.length;

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int count = 0; // Count of elements traversed

        // Traverse both arrays until we reach k-th element
        while(i < m && j < n) {
            int val;
            if(arr1[i] <= arr2[j]) {
                val = arr1[i++];
            } else {
                val = arr2[j++];
            }
            count++;
            if(count == k) return val; // Found k-th element
        }

        // If any elements remain in arr1
        while(i < m) {
            count++;
            if(count == k) return arr1[i];
            i++;
        }

        // If any elements remain in arr2
        while(j < n) {
            count++;
            if(count == k) return arr2[j];
            j++;
        }

        return -1; // Safety, though k is valid
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;

        System.out.println("K-th Element: " + kthElement(arr1, arr2, k)); // Output: 6
    }
}

