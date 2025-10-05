import java.util.Stack;

public class NSE {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 10, 8};
        int result[] = new int[arr.length]; // to store next smaller elements
        Stack<Integer> stack = new Stack<>(); // stack to keep potential smaller elements

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop all elements greater or equal to current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If stack empty → no smaller element, else top is next smaller
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element for future comparison
            stack.push(arr[i]);
        }

        // Print result
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
