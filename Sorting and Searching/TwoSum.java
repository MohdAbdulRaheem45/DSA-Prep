public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

        int left = 0;               // start pointer
        int right = arr.length - 1; // end pointer
        int sum = 0;
        boolean f = false;          // to check if pair found

        while (left < right) {
            sum = arr[left] + arr[right];

            if (sum == target) {        // ✅ Found the pair
                f = true;
                break;
            } else if (sum > target) {  // sum too big → decrease right
                right--;
            } else {                    // sum too small → increase left
                left++;
            }
        }

        if (f) {
            System.out.println("Indices: " + (left+1) + " " + (right+1));
        } else {
            System.out.println("No pair found");
        }
    }
}
