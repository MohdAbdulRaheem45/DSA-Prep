public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // target found at index i
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3};
        int target = 5;
        System.out.println("Index of target: " + linearSearch(arr, target));
    }
}
