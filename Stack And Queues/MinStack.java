import java.util.Stack;

// MinStack implementation using two stacks
class MinStack {

    private Stack<Integer> mainStack;  // Stack to store all elements
    private Stack<Integer> minStack;   // Stack to store minimum at each point

    // Constructor
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element x onto stack
    public void push(int x) {
        mainStack.push(x); // Push to main stack
        // If minStack is empty or x <= current minimum, push to minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop top element
    public void pop() {
        if (mainStack.isEmpty()) return; // If stack empty, do nothing
        int removed = mainStack.pop();   // Remove top element
        // If removed element is minimum, pop it from minStack as well
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get top element
    public int top() {
        if (mainStack.isEmpty()) return -1; // If empty, return -1
        return mainStack.peek();
    }

    // Retrieve minimum element
    public int getMin() {
        if (minStack.isEmpty()) return -1;  // If empty, return -1
        return minStack.peek();             // Top of minStack is current minimum
    }

    // Main function to test
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        // Push elements
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println("Current Min: " + stack.getMin()); // -3

        // Pop top element
        stack.pop();

        System.out.println("Top Element: " + stack.top());    // 0
        System.out.println("Current Min: " + stack.getMin()); // -2
    }
}
