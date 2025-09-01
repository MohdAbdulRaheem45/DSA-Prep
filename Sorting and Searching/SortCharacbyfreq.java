import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharacbyfreq {
    public static void main(String[] args) {
        String s = "tree";

        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // If character exists, increment count; else start with 1
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // At this point, map = {t=1, r=1, e=2}

        // Step 2: Create a list of characters (keys from the map)
        List<Character> chars = new ArrayList<>(map.keySet());

        // Step 3: Sort characters by their frequency in descending order
        chars.sort((a, b) -> map.get(b) - map.get(a));
        // Comparator explanation:
        // map.get(b) - map.get(a) → sorts characters with higher frequency first
        // Example: 'e' (2) comes before 't' (1) and 'r' (1)

        // Step 4: Build the result string based on sorted frequency
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int freq = map.get(c);  // frequency of current character
            for (int i = 0; i < freq; i++) {
                sb.append(c);        // append character 'freq' times
            }
        }

        // Step 5: Convert StringBuilder to String and print
        String result = sb.toString();
        System.out.println(result);  // Output example: "eetr" or "eert"
    }
}
