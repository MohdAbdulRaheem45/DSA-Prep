import java.util.HashMap;

public class P25 {

    // Function to find the minimum window substring
    public static String minWindow(String s, String t) {
        // Edge case: if either string is empty, return empty string
        if(s.length() == 0 || t.length() == 0) return "";

        // Step 1: Count frequency of each character in t
        HashMap<Character,Integer> tCount = new HashMap<>();
        for(char c : t.toCharArray()){
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Initialize sliding window variables
        int start = 0, end = 0;          // Window pointers
        int minLen = Integer.MAX_VALUE;  // Minimum window length
        int winStart = 0;                // Start index of minimum window
        int formed = 0;                  // How many unique chars satisfy requirement
        int required = tCount.size();    // Total unique characters in t to match

        // Map to track character count in current window
        HashMap<Character,Integer> windowCount = new HashMap<>();

        // Step 3: Start sliding the window
        while(end < s.length()){
            char c = s.charAt(end);
            // Add current character to window count
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // Step 4: Check if current character completes requirement
            if(tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()){
                formed++;
            }

            // Step 5: Try to shrink the window from start while it remains valid
            while(start <= end && formed == required){
                char startChar = s.charAt(start);

                // Update minimum window if smaller than previous
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    winStart = start;
                }

                // Remove the startChar from window as we shrink
                windowCount.put(startChar, windowCount.get(startChar) - 1);

                // If removing it breaks requirement, decrease formed
                if(tCount.containsKey(startChar) && windowCount.get(startChar) < tCount.get(startChar)){
                    formed--;
                }

                // Move start forward to continue shrinking
                start++;
            }

            // Step 6: Expand window by moving end
            end++;
        }

        // Step 7: Return the minimum window substring
        return minLen == Integer.MAX_VALUE ? "" : s.substring(winStart, winStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        // Output: Minimum window substring
        System.out.println("Minimum window substring: " + minWindow(s, t));
    }
}
