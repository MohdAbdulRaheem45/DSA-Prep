import java.util.HashMap;

public class P12 {//longest subarray with the sum=k
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        int endIndex = -1;

        map.put(0, -1); // base case

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                if (len > maxLen) {
                    maxLen = len;
                    endIndex = i;
                }
            }

            // store only first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        System.out.println("Length of longest subarray with sum " + k + ": " + maxLen);

        if (endIndex != -1) {
            int startIndex = endIndex - maxLen + 1;
            System.out.print("Longest subarray: ");
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("No subarray found with sum " + k);
        }
    }
}
