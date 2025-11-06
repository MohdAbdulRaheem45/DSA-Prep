import java.util.*;

class Solution {

    /**
     * Backtracking helper to build valid parentheses strings.
     *
     * @param openLeft   how many '(' we still can place
     * @param closeLeft  how many ')' we still can place
     * @param sb         current building string (StringBuilder for efficiency)
     * @param result     list to collect valid combinations
     */
    private static void backtrack(int openLeft, int closeLeft, StringBuilder sb, List<String> result) {
        // Base case: no parentheses left to place -> one valid string created
        if (openLeft == 0 && closeLeft == 0) {
            result.add(sb.toString());
            return;
        }

        // If we can put an '(' put it (we always may place '(' while we have them)
        if (openLeft > 0) {
            sb.append('(');
            backtrack(openLeft - 1, closeLeft, sb, result); // place one '(' and recurse
            sb.deleteCharAt(sb.length() - 1);               // backtrack (undo)
        }

        // We may place ')' only if there are more ')' available than '(' remaining used,
        // i.e., closeLeft > openLeft ensures we don't place ')' that would make string invalid.
        if (closeLeft > openLeft) {
            sb.append(')');
            backtrack(openLeft, closeLeft - 1, sb, result); // place one ')' and recurse
            sb.deleteCharAt(sb.length() - 1);               // backtrack (undo)
        }
    }

    /**
     * Generate all combinations of well-formed parentheses for n pairs.
     *
     * @param n number of pairs
     * @return list of all valid parentheses strings
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        backtrack(n, n, new StringBuilder(), result);
        return result;
    }

    // Local test for quick run in VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        List<String> ans = sol.generateParenthesis(n);
        System.out.println(ans);
        // expected (order may vary): ["((()))","(()())","(())()","()(())","()()()"]
    }
}
