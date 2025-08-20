public class P38 {//maximum sum circular subarray
    static int kadane(int[] arr) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currsum += arr[i];
            if (currsum > maxsum) {
                maxsum = currsum;
            }
            if (currsum < 0) {
                currsum = 0;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[] arr = {5, -3, 5};
        int maxnormal = kadane(arr);

        int totalsum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalsum += arr[i];
            arr[i] = -arr[i];  // invert elements
        }

        int maxInverted = kadane(arr); // max sum in inverted array = -min subarray sum in original
        int maxcircular = totalsum + maxInverted; // max circular sum

        // If maxcircular is 0, means all elements are negative, so return maxnormal only
        if (maxcircular == 0) {
            System.out.println(maxnormal);
        } else {
            System.out.println(Math.max(maxnormal, maxcircular));
        }
    }
}
