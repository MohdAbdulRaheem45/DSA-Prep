public class P43 { // Product Except Self
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int n = arr.length;

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        // Prefix products
        prefix[0] = 1;
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] * arr[i-1];
        }

        // Suffix products
        suffix[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            suffix[i] = suffix[i+1] * arr[i+1];
        }

        // Final answer
        int ans[] = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = prefix[i] * suffix[i];
            System.out.println(ans[i]);
        }
    }
}
