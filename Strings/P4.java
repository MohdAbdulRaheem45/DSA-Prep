import java.util.HashMap;

public class P4 { // Valid Anagram using HashMap
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarama";

        if (s.length() != t.length()) {
            System.out.println(false); 
            return; // stop execution
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count chars in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println(false);
                return; // stop if char not in map
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // Final check
        if (map.isEmpty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
