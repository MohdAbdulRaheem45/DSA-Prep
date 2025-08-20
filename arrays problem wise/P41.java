public class P41 {//merge sorted arrays
    public static void main(String[] args) {
        int a1[] = {1,2,3,0,0,0};
        int a2[] = {4,5,6};
        int m = 3;
        int n = a2.length;

        int i = m - 1;      // last valid index in a1
        int j = n - 1;      // last index in a2
        int k = m + n - 1;  // last index in final merged array

        // Compare from the back
        while (i >= 0 && j >= 0) {
            if (a1[i] > a2[j]) {
                a1[k] = a1[i];
                i--;
            } else {
                a1[k] = a2[j];
                j--;
            }
            k--;
        }

        // Copy remaining elements from a2 (if any)
        while (j >= 0) {
            a1[k] = a2[j];
            j--;
            k--;
        }

        // Print final merged array
        for (int num : a1) {
            System.out.print(num + " ");
        }
    }
}
