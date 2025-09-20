public class RotateList {

    // Node class for linked list
    static class Node {
        int data;
        Node next;
        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // Function to rotate the list by k
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // Step 1: find length of the list
        Node temp = head;
        int length = 1;
        while(temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: make the list circular
        temp.next = head;

        // Step 3: calculate new tail position
        k = k % length;
        int stepsToNewTail = length - k;

        // Step 4: move to new tail
        Node newTail = head;
        for(int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: set new head and break the circle
        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example list: 1 -> 2 -> 3 -> 4 -> 5
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("Original List:");
        printList(n1);

        int k = 2;
        Node rotated = rotateRight(n1, k);
        System.out.println("Rotated List by " + k + ":");
        printList(rotated);
    }
}

