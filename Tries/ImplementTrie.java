// Each TrieNode represents ONE character in the Trie
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 26 lowercase letters (a–z)
    boolean isEnd = false; // Marks end of a valid word

    // Checks if current node has a child for given char
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // Puts a new node for given char
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    // Gets the reference to the next node (child)
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
}

class Trie {
    private TrieNode root; // root of the Trie

    public Trie() {
        root = new TrieNode(); // initialize root (empty node)
    }

    // INSERT a word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If char not present, create a new node
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            // Move to next node
            node = node.get(ch);
        }
        node.isEnd = true; // Mark end of the word
    }

    // SEARCH for a complete word
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // If char not found → word not present
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch); // Move deeper
        }
        // Only true if the last node is marked as end of a word
        return node.isEnd;
    }

    // Check if any word in Trie starts with this prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
