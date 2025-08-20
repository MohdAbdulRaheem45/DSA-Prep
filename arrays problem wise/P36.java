public class P36 {//most consecutive ones
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 1};
        int count = 0;      // current streak
        int maxCount = 0;   // max streak

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;                        // extend streak
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;                      // reset streak
            }
        }

        System.out.println("Maximum consecutive 1s: " + maxCount);
    }
}
