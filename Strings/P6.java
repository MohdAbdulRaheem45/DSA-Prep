public class P6 {
    // Brute force approach
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            // Take substring of haystack from i to i+m
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // found match
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // 0
        System.out.println(strStr("leetcode", "leeto")); // -1
    }
}
