public class P35_twopointer {
    public static void main(String[] args) {
        int arr[] = {4, 0, 1, 3, 5};
        int n = arr.length;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trapped = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];  // update barrier
                } else {
                    trapped += leftMax - arr[left]; // water above current bar
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];  // update barrier
                } else {
                    trapped += rightMax - arr[right];
                }
                right--;
            }
        }

        System.out.println("The trapped water is " + trapped);
    }
}
