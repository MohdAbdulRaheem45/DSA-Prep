public class ChkListIsAPalindrome {
    static class Node {
        int data;
        Node next;
        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // Function to reverse a linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;  // save next
            curr.next = prev;       // reverse pointer
            prev = curr;            // move prev
            curr = next;            // move curr
        }
        return prev; // new head of reversed list
    }

    // Function to check if the list is a palindrome
    public static boolean ListIsAPalindrome(Node head) {
        if (head == null || head.next == null) return true; // 0 or 1 node is palindrome

        // Step 1: Find middle (slow will be middle)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half starting from slow
        Node secondHalfHead = reverse(slow);

        // Step 3: Compare first half and second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean result = true;
        while (p2 != null) {  // check until second half finishes
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;  // ❌ You missed this step in your code
        }

        return result;
    }

    // Helper to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 2 -> 1
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("Is Palindrome? " + ListIsAPalindrome(n1)); // ✅ true
    }
}
