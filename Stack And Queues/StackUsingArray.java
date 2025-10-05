// Stack implementation using Array
public class StackUsingArray {
    int maxSize;    // Maximum size of the stack
    int arr[];      // Array to store stack elements
    int top;        // Index of the top element

    // Constructor to initialize the stack
    StackUsingArray(int size) {
        maxSize = size;
        arr = new int[size];
        top = -1;   // -1 indicates stack is empty
    }

    // Push a value onto the stack
    public void push(int value) {
        if (top == arr.length - 1) {   // Check for stack overflow
            System.out.println("Stack is full!");
            return;
        }
        arr[++top] = value;  // Increment top and insert value
    }

    // Pop a value from the stack
    public int pop() {
        if (top == -1) {   // Check for stack underflow
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--]; // Return top element and decrement top
    }

    // Peek at the top value without removing it
    public int peek() {
        if (top == -1) {   // Check if stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];   // Return top element
    }

    // Print the stack from top to bottom
    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println("null");
    }

    // Main function to test stack operations
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(3); // Create stack of size 3

        stack.push(10);   // Push 10
        stack.push(20);   // Push 20
        stack.push(30);   // Push 30
        stack.printStack(); // Output: 30 -> 20 -> 10 -> null

        stack.push(40);   // Try to push 40 (Stack is full!)

        System.out.println("The element popped: " + stack.pop()); // Pop top element (30)
        stack.printStack(); // Output: 20 -> 10 -> null

        System.out.println("Top element is: " + stack.peek()); // Peek top element (20)
    }
}
