class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // take first string as base
        String prefix = strs[0];

        // compare prefix with each word
        for (int i = 1; i < strs.length; i++) {
            // while current word doesn’t start with prefix
            while (!strs[i].startsWith(prefix)) {
                // shorten the prefix by removing last char
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
