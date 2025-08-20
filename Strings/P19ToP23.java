public class P19ToP23{

    // P61. Remove vowels from string
    public static String removeVowels(String s) {
        // Regex: [aeiouAEIOU] matches all vowels (both uppercase and lowercase)
        return s.replaceAll("[aeiouAEIOU]", "");
    }

    // P62. Count vowels & consonants
    public static void countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        s = s.toLowerCase(); // Convert to lowercase for easy checking
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') { // Only check alphabets
                if ("aeiou".indexOf(c) != -1) // If character is a vowel
                    vowels++;
                else
                    consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // P63. Count words in a sentence
    public static int countWords(String s) {
        // Trim removes leading/trailing spaces, split("\\s+") splits by 1 or more spaces
        if (s == null || s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    // P64. Replace spaces with specific char
    public static String replaceSpaces(String s, char ch) {
        // Replace all spaces ' ' with the given character
        return s.replace(' ', ch);
    }

    // P65. Reverse each word in a sentence
    public static String reverseWords(String s) {
        String[] words = s.split(" "); // Split by spaces
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            // Reverse each word using StringBuilder reverse()
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim(); // Remove last extra space
    }

    // ----------------- Main Method to Test -----------------
    public static void main(String[] args) {
        String text = "Hello World";

        // P61
        System.out.println("Remove vowels: " + removeVowels(text)); // Hll Wrld

        // P62
        countVowelsConsonants(text); // Vowels: 3, Consonants: 7

        // P63
        System.out.println("Word count: " + countWords("Hello world, welcome to Java")); // 5

        // P64
        System.out.println("Replace spaces: " + replaceSpaces(text, '-')); // Hello-World

        // P65
        System.out.println("Reverse each word: " + reverseWords(text)); // olleH dlroW
    }
}

