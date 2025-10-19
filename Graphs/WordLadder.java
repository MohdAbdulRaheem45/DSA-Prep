import java.util.*;

class Solution {
    // Helper class to store word + current transformation length
    static class Pair {
        String word; // current word
        int len;     // number of transformations from beginWord
        Pair(String w, int l){
            this.word = w;
            this.len = l;
        }
    }

    public int ladderLength(String begin, String end, List<String> wordList) {
        // Convert wordList to a HashSet for O(1) lookup
        Set<String> s = new HashSet<>(wordList);

        // If endWord is not in the list, transformation is impossible
        if(!s.contains(end)) return 0;

        Queue<Pair> q = new LinkedList<>();      // BFS queue
        Set<String> visited = new HashSet<>();   // visited words
        q.add(new Pair(begin, 1));               // start with beginWord, length=1
        visited.add(begin);

        while(!q.isEmpty()){
            Pair p = q.poll();                   // get current word
            String curWord = p.word;
            int curlen = p.len;

            // If we reached the target word, return number of steps
            if(curWord.equals(end)) return curlen;

            char[] curChars = curWord.toCharArray();

            // Try changing each letter of the word
            for(int i = 0; i < curChars.length; i++){
                char original = curChars[i];     // save original char

                // Try all lowercase letters
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == original) continue; // skip same letter

                    curChars[i] = c;
                    String newWord = new String(curChars);

                    // If new word exists in wordList and not visited
                    if(s.contains(newWord) && !visited.contains(newWord)){
                        visited.add(newWord);               // mark visited
                        q.add(new Pair(newWord, curlen+1)); // add to queue with +1 step
                    }
                }

                curChars[i] = original; // restore original char before next iteration
            }
        }

        return 0; // no transformation sequence found
    }

    // ✅ Test driver
    public static void main(String[] args){
        Solution sol = new Solution();
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest transformation length: " + sol.ladderLength(begin, end, wordList));
    }
}
