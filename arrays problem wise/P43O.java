public class P43O {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;

        // ans[i] will store the final product except self
        int ans[] = new int[n];

        // Step 1: Compute prefix products (products of all elements to the left of i)
        ans[0] = 1; // no elements to the left of index 0
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
            // ans[i] = product of all elements to the left of arr[i]
        }

        // Step 2: Multiply with suffix products (products of all elements to the right of i)
        int suffixprod = 1; // initially, no elements to the right of last element
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffixprod; // multiply left product with right product
            suffixprod *= arr[i];          // update suffix product for next element to the left
        }

        // Step 3: Print final result
        for(int num : ans) {
            System.out.println(num);
        }
    }
}
