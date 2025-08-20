public class P26 { // Valid Palindrome II
    // Main function to check if string is valid palindrome after deleting at most 1 character
    public static boolean valid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // If characters match, move both pointers inward
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // If mismatch happens → try removing one character
                // Case 1: Skip left character
                // Case 2: Skip right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true; // Already palindrome
    }

    // Helper function to check if a substring (l to r) is palindrome
    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aba";   // already palindrome
        String s2 = "abc";   // cannot be palindrome
        String s3 = "abca";  // can remove 'b' or 'c'
        String s4 = "deeee"; // can remove 'd'

        System.out.println(valid(s1)); // true
        System.out.println(valid(s2)); // false
        System.out.println(valid(s3)); // true
        System.out.println(valid(s4)); // true
    }
}
