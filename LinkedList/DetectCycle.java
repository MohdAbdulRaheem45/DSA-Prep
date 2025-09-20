public class DetectCycle {
    
    // Node class represents each element in the linked list
    static class Node {
        int data;   // value stored in node
        Node next;  // pointer to next node

        Node(int value) {
            this.data = value;
            this.next = null; // initially next is null
        }
    }

    static Node head = null; // head points to the first node

    // Function to detect cycle in a linked list
    public static boolean detectCycle(Node head) {
        Node slow = head; // moves 1 step at a time
        Node fast = head; // moves 2 steps at a time

        // traverse the list
        while(fast != null && fast.next != null) {
            slow = slow.next;        // move slow by 1
            fast = fast.next.next;   // move fast by 2

            // if slow and fast meet, cycle exists
            if(slow == fast) {
                return true;
            }
        }

        return false; // no cycle found
    }

    public static void main(String[] args) {
        // Create nodes
        Node f = new Node(10);
        Node s = new Node(20);
        Node r = new Node(30);

        // Link nodes and create a cycle: 10 -> 20 -> 30 -> 20
        head = f;
        f.next = s;
        s.next = r;
        r.next = s; // cycle here

        System.out.println(detectCycle(head)); // Output: true
    }
}
