import java.util.*;
// TrieNode class — defines structure of each node in Trie
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // each node can have up to 26 children (a–z)
    boolean isEnd = false;                  // true when this node marks the end of a root word

    // checks if current node already has a link for character 'ch'
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // creates a new link for character 'ch'
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    // moves to the next node connected by character 'ch'
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
}

// Main class — builds Trie and uses it to replace words
class Solution {
    private static TrieNode root; // root node of Trie (shared by all functions)

    public Solution() {
        root = new TrieNode(); // initialize root when object created
    }

    // function to insert a root word into the Trie
    public static void insert(String word) {
        TrieNode node = root; // start from root
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // if link for current char doesn't exist, create a new one
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            // move to the next node
            node = node.get(ch);
        }
        // mark end of this word
        node.isEnd = true;
    }

    // function to find the shortest prefix for a given word
    public static String findPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        // traverse each character of word
        for (char c : word.toCharArray()) {

            // if path breaks (no child node), return original word
            if (!node.containsKey(c)) {
                return word;
            }

            // move to next node and append char to prefix
            node = node.get(c);
            prefix.append(c);

            // if we reached a word-end, return the prefix (shortest root found)
            if (node.isEnd) {
                return prefix.toString();
            }
        }

        // if we traversed all characters without finding isEnd, return word itself
        return word;
    }

    // main function: builds Trie from dictionary and replaces words in sentence
    public String replaceWords(List<String> dictionary, String sentence) {
        // 1. insert all dictionary root words into Trie
        for (String word : dictionary) {
            insert(word);
        }

        // 2. split sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // 3. for each word in sentence, replace with shortest root if possible
        for (String wor : words) {
            if (result.length() > 0) result.append(" "); // space between words
            result.append(findPrefix(wor)); // append replaced or original word
        }

        // 4. return the final processed sentence
        return result.toString();
    }
}
