public class P5 {//kadens algorithm
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;

        int start = 0, end = 0, s = 0;

        for (int i = 0; i < arr.length; i++) {
            currsum += arr[i];

            if (currsum > maxsum) {
                maxsum = currsum;
                start = s;  // update the final start
                end = i;    // update the final end
            }

            if (currsum < 0) {
                currsum = 0;
                s = i + 1; // reset start index for next subarray
            }
        }

        // Print result
        System.out.println("Max Sum: " + maxsum);
        System.out.print("Subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + (i < end ? ", " : ""));
        }
        System.out.println("]");
    }
}

