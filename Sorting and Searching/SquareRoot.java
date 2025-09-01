public class SquareRoot {
    public static int sqrt(int n) {
        if (n == 0 || n == 1) return n; // Edge cases
        
        int left = 1, right = n, ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= n / mid) {  // mid*mid <= n, use division to avoid overflow
                ans = mid;         // mid is a possible answer
                left = mid + 1;    // try to find a bigger square root
            } else {
                right = mid - 1;   // mid*mid > n, reduce the range
            }
        }
        
        return ans; // integer part of square root
    }
    
    public static void main(String[] args) {
        int n = 17;
        System.out.println("Integer square root of " + n + " is " + sqrt(n));
    }
}
