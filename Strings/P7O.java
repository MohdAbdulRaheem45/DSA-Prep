import java.util.*;

public class P7O{
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Step 1: Count frequency of each character
            int[] count = new int[26]; // assuming lowercase letters
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Step 2: Convert count[] to a unique key string
            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append("#").append(num); 
                // e.g. "eat" -> "#1#0#0...#1..." etc.
            }

            // Step 3: Put into hashmap
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }

        // Step 4: Return grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","hit","ith","lamos"};
        System.out.println(groupAnagrams(arr));
    }
}
