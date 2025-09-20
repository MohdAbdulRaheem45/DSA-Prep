public class RemoveCycle {

    // Node class: each node has data and pointer to next
    static class Node {
        int data;
        Node next;
        Node(int value) {
            this.data = value;
            this.next = null; // initially points to null
        }
    }

    static Node head = null; // head points to the first node

    // Function to detect and remove a cycle
    public static void removeCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;

        // Step 1: Detect cycle using slow-fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow by 1
            fast = fast.next.next;     // move fast by 2
            if (slow == fast) {        // if they meet, cycle exists
                cycleExists = true;
                break;
            }
        }

        if (!cycleExists) return; // no cycle, nothing to remove

        // Step 2: Find start of cycle
        slow = head;  // move one pointer to head
        Node prev = null; // prev will track the node before fast

        while (slow != fast) {     // move both one step at a time
            prev = fast;           // prev follows fast
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle
        prev.next = null; // prev was pointing into the cycle, now points to null
    }

    // Utility function to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: 10->20->30->40->20 (cycle)
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);

        head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // cycle here

        removeCycle(head); // removes the cycle safely

        printList(head); // Output: 10 -> 20 -> 30 -> 40 -> null
    }
}
