public class MergeTwolist {

    // Node class represents each element of the linked list
    static class Node {
        int data;   // the value stored in node
        Node next;  // pointer to the next node

        Node(int value) {
            this.data = value;
            this.next = null; // initially points to null
        }
    }

    // Function to merge two sorted linked lists
    public static Node mergeSortedList(Node l1, Node l2) {
        Node dummy = new Node(0); // Dummy node helps simplify merging
        Node tail = dummy;        // Tail points to the last node in merged list

        // Traverse both lists until one ends
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;  // attach smaller node to merged list
                l1 = l1.next;    // move l1 forward
            } else {
                tail.next = l2;  // attach smaller node to merged list
                l2 = l2.next;    // move l2 forward
            }
            tail = tail.next;    // move tail forward
        }

        // Attach remaining nodes if any
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next; // skip dummy and return actual head
    }

    // Utility function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example List 1: 10 -> 20 -> 30
        Node l1 = new Node(10);
        l1.next = new Node(20);
        l1.next.next = new Node(30);

        // Example List 2: 15 -> 25 -> 35
        Node l2 = new Node(15);
        l2.next = new Node(25);
        l2.next.next = new Node(35);

        Node merged = mergeSortedList(l1, l2); // merge the two lists
        printList(merged); // Output: 10 -> 15 -> 20 -> 25 -> 30 -> 35 -> null
    }
}
