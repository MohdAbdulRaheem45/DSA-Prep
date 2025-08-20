import java.util.Stack;

public class P5 {// valid parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket → push the expected closing one
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket → check with stack top
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false; // mismatch
                }
            }
        }

        // If stack is empty → all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("({[]})"));   // true
    }
}
