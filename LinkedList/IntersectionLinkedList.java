public class IntersectionLinkedList {

    // Node class represents each element in the linked list
    static class Node {
        int data;   // The value stored in the node
        Node next;  // Pointer to the next node

        Node(int value) {
            this.data = value;
            this.next = null; // Initially, next is null
        }
    }

    // Function to find intersection of two linked lists
    public static Node getIntersection(Node headA, Node headB) {
        Node a = headA; // Pointer for list A
        Node b = headB; // Pointer for list B

        // Traverse both lists simultaneously
        // Switch heads when reaching the end
        while (a != b) {
            a = (a == null) ? headB : a.next; // If reached end, switch to other list's head
            b = (b == null) ? headA : b.next;
        }

        // Either intersection node or null (if no intersection)
        return a;
    }

    // Utility function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> "); // Print value
            temp = temp.next;                     // Move to next node
        }
        System.out.println("null");               // End of list
    }

    public static void main(String[] args) {
        // Create shared nodes (these will be common to both lists)
        Node shared1 = new Node(40);
        Node shared2 = new Node(50);
        shared1.next = shared2;

        // List A: 10 -> 20 -> 30 -> 40 -> 50
        Node a1 = new Node(10);
        Node a2 = new Node(20);
        Node a3 = new Node(30);
        a1.next = a2;
        a2.next = a3;
        a3.next = shared1; // Link to shared part

        // List B: 15 -> 40 -> 50
        Node b1 = new Node(15);
        b1.next = shared1; // Link to shared part

        // Find intersection
        Node intersection = getIntersection(a1, b1);

        // Print result
        if (intersection != null)
            System.out.println("Intersection at node with value: " + intersection.data);
        else
            System.out.println("No intersection (null)");
    }
}
