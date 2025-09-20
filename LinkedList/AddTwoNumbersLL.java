public class AddTwoNumbersLL {
    static class Node {
        int data;
        Node next;
        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // Function to add two numbers represented by linked lists
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);   // dummy node to simplify result list creation
        Node curr = dummy;          // pointer to build result list
        int carry = 0;              // carry for addition

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.data : 0;  // if l1 finished, use 0
            int y = (l2 != null) ? l2.data : 0;  // if l2 finished, use 0

            int sum = x + y + carry;  // add digits + carry
            carry = sum / 10;         // compute new carry
            int digit = sum % 10;     // digit to store in node

            curr.next = new Node(digit); // create new node for digit
            curr = curr.next;

            // move forward in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry remains, add it as new node
        if (carry > 0) {
            curr.next = new Node(carry);
        }

        return dummy.next; // skip dummy, return actual head
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
        // First number: 342 (stored as 2->4->3)
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Second number: 465 (stored as 5->6->4)
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.print("Number 1: ");
        printList(l1);
        System.out.print("Number 2: ");
        printList(l2);

        Node result = addTwoNumbers(l1, l2);

        System.out.print("Sum: ");
        printList(result);  // Expected: 7 -> 0 -> 8
    }
}
