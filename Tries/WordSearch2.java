import java.util.*;
// TrieNode class for Trie structure
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Each node can have 26 possible children (a-z)
    String word = null; // If this node marks the end of a word, we store that word here

    // Check if child for this character exists
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // Get child node for a given character
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    // Create/put a new node for this character
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
}

// Main Solution class
class Solution {
    private static TrieNode root;         // Root of the Trie
    static List<String> result;           // To store all found words

    // Constructor to initialize root and result
    public Solution() {
        root = new TrieNode();
        result = new ArrayList<>();
    }

    // Insert a word into the Trie
    public static void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            // Create node if not present
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            // Move to the next node
            node = node.get(c);
        }
        // Store complete word at the end node
        node.word = word;
    }

    // DFS traversal to find words on the board
    public static void dfs(int i, int j, char[][] board, TrieNode node) {
        // 1️⃣ Boundary check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char ch = board[i][j];

        // 2️⃣ If cell already visited OR no path in Trie → stop
        if (ch == '#' || !node.containsKey(ch)) return;

        // Move to the next node in Trie
        node = node.get(ch);

        // 3️⃣ Found a complete word
        if (node.word != null) {
            result.add(node.word);  // add to answer list
            node.word = null;       // avoid duplicates
        }

        // 4️⃣ Mark current cell visited
        board[i][j] = '#';

        // 5️⃣ Explore all 4 directions (Backtracking)
        dfs(i - 1, j, board, node); // up
        dfs(i + 1, j, board, node); // down
        dfs(i, j - 1, board, node); // left
        dfs(i, j + 1, board, node); // right

        // 6️⃣ Restore the cell for next paths (backtracking)
        board[i][j] = ch;
    }

    // Main function to find all words
    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // Start DFS from each cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (root.containsKey(ch)) {
                    dfs(i, j, board, root);
                }
            }
        }

        return result;
    }
}
