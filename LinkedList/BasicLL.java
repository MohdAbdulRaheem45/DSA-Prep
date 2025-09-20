public class BasicLL {

    // Node class represents each element in the linked list
    static class Node {
        int data;   // Data stored in node
        Node next;  // Pointer to next node

        Node(int value) {
            this.data = value;
            this.next = null; // Initially next is null
        }
    }

    static Node head = null; // Head points to the first node of the list

    // Insert a new node at the beginning
    public static void insertAtBegin(int data) {
        Node newNode = new Node(data); // Create new node
        newNode.next = head;           // Link new node to current head
        head = newNode;                // Update head to new node
    }

    // Insert a new node at the end
    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null) {             // If list is empty
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {     // Traverse to the last node
            temp = temp.next;
        }
        temp.next = newNode;           // Link last node to new node
    }

    // Insert a node at any given position (1-based index)
    public static void insertAtAnyPosition(int data, int pos) {
        Node newNode = new Node(data);

        if(pos == 1) {                 // Insert at beginning
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for(int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if(temp == null) {             // Position out of range
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;      // Link new node
        temp.next = newNode;
    }

    // Delete the first node
    public static void deleteFromBegin() {
        if(head == null) return;       // Empty list
        head = head.next;              // Move head to next node
    }

    // Delete the last node
    public static void deleteFromEnd() {
        if(head == null) return;       // Empty list
        if(head.next == null) {        // Single node
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null) { // Stop at second last node
            temp = temp.next;
        }
        temp.next = null;              // Remove last node
    }

    // Delete a node from a specific position (1-based)
    public static void deleteFromAnyPosition(int pos) {
        if(head == null) return;       // Empty list
        if(pos == 1) {                 // Delete head
            head = head.next;
            return;
        }

        Node temp = head;
        for(int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if(temp == null || temp.next == null) { // Position out of range
            System.out.println("Position out of range");
            return;
        }

        temp.next = temp.next.next;    // Bypass the node to delete
    }

    // Search for an element in the list
    public static boolean searchElement(int key) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == key) {
                return true;          // Found the element
            }
            temp = temp.next;
        }
        return false;                 // Element not found
    }

    // Print the linked list
    public static void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Manually create 3-node list
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        head = first;
        first.next = second;
        second.next = third;

        printList();                 // Output: 10 -> 20 -> 30 -> NULL
        System.out.println();

        insertAtBegin(5);            // 5 -> 10 -> 20 -> 30
        printList();
        System.out.println();

        deleteFromAnyPosition(3);    // Delete 3rd node (20)
        printList();                 // 5 -> 10 -> 30
        System.out.println();

        insertAtAnyPosition(50, 3);  // Insert 50 at position 3
        printList();                 // 5 -> 10 -> 50 -> 30
        System.out.println();

        System.out.println(searchElement(10)); // true
        System.out.println(searchElement(99)); // false
    }
}
