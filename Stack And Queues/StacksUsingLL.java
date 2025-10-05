 // Stack implementation using Linked List
public class StacksUsingLL {

    // Node class represents each element in the stack
    static class Node {
        int data;   // Value of the node
        Node next;  // Pointer to the next node

        // Constructor to create a new node
        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    static Node top = null;  // Top of the stack

    // Push operation: add element to the top of stack
    public static void push(int value) {
        Node newnode = new Node(value); // Create a new node
        newnode.next = top;             // Link new node to current top
        top = newnode;                  // Update top to new node
    }

    // Pop operation: remove and return element from top of stack
    public static int pop() {
        if (top == null) {  // Check for empty stack
            System.out.println("Stack is empty!");
            return -1;
        }
        int val = top.data; // Save value to return
        top = top.next;     // Move top to next node
        return val;
    }

    // Peek operation: return top element without removing
    public static int peek() {
        if (top == null) {  // Check for empty stack
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    // Print the stack from top to bottom
    public static void printList() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main function to test stack operations
    public static void main(String[] args) {
        // Creating initial stack manually
        Node first = new Node(10);
        first.next = new Node(20);
        first.next.next = new Node(30);
        top = first;  // Set top of stack
        printList();  // Output: 10 -> 20 -> 30 -> null

        // Push new elements
        push(25);
        push(35);
        printList();  // Output: 35 -> 25 -> 10 -> 20 -> 30 -> null

        // Pop an element
        System.out.println("Popped element: " + pop());  // Output: 35
        printList();  // Updated stack

        // Peek top element
        System.out.println("Top element: " + peek());   // Output: 25
    }
}
