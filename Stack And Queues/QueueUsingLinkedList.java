public class QueueUsingLinkedList {
    // Node class for each element
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    Node front, rear;  // Front points to first node, rear points to last node

    // Constructor - initialize empty queue
    QueueUsingLinkedList() {
        front = rear = null;
    }

    // Enqueue -> Add element at the rear
    public void enqueue(int data) {
        Node newnode = new Node(data);

        if (front == null) {        // If queue is empty
            front = rear = newnode; // Both front and rear point to newnode
            return;
        }

        rear.next = newnode;  // Link new node at the end
        rear = newnode;       // Update rear
    }

    // Dequeue -> Remove element from the front
    public int dequeue() {
        if (front == null) {        // If queue is empty
            System.out.println("Queue is empty!");
            return -1;
        }

        int data = front.data;      // Get front data
        front = front.next;         // Move front to next node

        if (front == null) {        // If queue became empty
            rear = null;            // Reset rear too
        }

        return data;
    }

    // Peek -> See front element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Print Queue
    public void printqueue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " || ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printqueue();   // 20 || 30 || 40 || 50 || null

        System.out.println("Dequeued element: " + queue.dequeue()); // 20
        System.out.println("Front element: " + queue.peek());       // 30

        queue.printqueue();   // 30 || 40 || 50 || null
    }
}
