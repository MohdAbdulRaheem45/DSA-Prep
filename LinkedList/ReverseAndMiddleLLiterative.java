public class ReverseAndMiddleLLiterative {
    
    // Node class: represents each element in the linked list
    static class Node {
        int data;    // value stored in the node
        Node next;   // reference (pointer) to the next node

        Node(int value) {
            this.data = value;
            this.next = null; // initially, next is null
        }
    }

    static Node head = null; // head points to the first node

    // Iterative method to reverse the linked list
    public static Node reverse(Node head) {
        Node prev = null;   // previous node (will become new head)
        Node curr = head;   // current node we're processing
        while(curr != null) {        // traverse until end of list
            Node next = curr.next;   // temporarily store next node
            curr.next = prev;        // reverse the pointer of current node
            prev = curr;             // move prev forward
            curr = next;             // move curr forward
        }
        return prev; // prev is the new head after reversal
    }

    // Find middle node using slow-fast pointer method
    public static int middle(Node head) {
        Node slow = head; // moves 1 step at a time
        Node fast = head; // moves 2 steps at a time

        while(fast != null && fast.next != null) {
            slow = slow.next;          // move slow by 1
            fast = fast.next.next;     // move fast by 2
        }

        return slow.data; // slow is now at the middle node
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node temp = head;             // start from head
        while(temp != null) {         // traverse until end
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next;         // move to next node
        }
        System.out.println("null");   // end of list
    }

    public static void main(String[] args) {
        // Creating 3 nodes
        Node f = new Node(10);
        Node s = new Node(20);
        Node t = new Node(30);

        // Linking nodes
        head = f;
        f.next = s;
        s.next = t;

        // Print original list
        System.out.println("Original List:");
        printList(head);

        // Find and print middle of original list
        System.out.println("Middle of Original List: " + middle(head));

        // Reverse the linked list iteratively
        head = reverse(head);

        // Print reversed list
        System.out.println("Reversed List:");
        printList(head);

        // Find and print middle of reversed list
        System.out.println("Middle of Reversed List: " + middle(head));
    }
}
