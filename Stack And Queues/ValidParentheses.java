import java.util.Stack;

public class ValidParentheses {

    // Function to check if the string has valid parentheses
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            // If opening '{', push expected closing '}'
            if(c == '{') {
                stack.push('}');
            }
            // If opening '[', push expected closing ']'
            else if(c == '[') {
                stack.push(']');
            }
            // If opening '(', push expected closing ')'
            else if(c == '(') {
                stack.push(')');
            }
            // If current char is a closing bracket
            else {
                // Stack should not be empty and top should match current char
                if(stack.isEmpty() || stack.pop() != c) {
                    return false; // invalid parentheses
                }
            }
        }

        // If stack is empty at the end, all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]";         // Simple valid brackets
        String s1 = "({[]})";    // Nested valid brackets
        String s3 = "[]{)";      // Invalid brackets

        System.out.println(isValid(s));   // true
        System.out.println(isValid(s1));  // true
        System.out.println(isValid(s3));  // false
    }
}
