public class Circularqueue {
    int arr[];        // Array to store queue elements
    int front;        // Index of the front element
    int rear;         // Index of the last element
    int capacity;     // Maximum size of the queue
    int size;         // Current number of elements in the queue

    // Constructor to initialize queue
    Circularqueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;       // Start position
        rear = -1;       // Empty queue initially
        size = 0;        // No elements yet
    }

    // Enqueue -> Add element at the rear
    public void enqueue(int data) {
        if (isFull()) {   // Check if queue is full
            System.out.println("Queue is full!");
            return;
        }
        // Move rear forward in circular way: (rear+1) % capacity
        rear = (rear + 1) % capacity;
        arr[rear] = data;   // Insert element
        size++;             // Increase size
    }

    // Dequeue -> Remove element from the front
    public int dequeue() {
        if (isEmpty()) {   // Check if queue is empty
            System.out.println("Queue is empty!");
            return -1;     // Return -1 if empty
        }
        int data = arr[front];          // Get front element
        front = (front + 1) % capacity; // Move front forward circularly
        size--;                         // Decrease size
        return data;                    // Return removed element
    }

    // Peek -> Get front element without removing
    public int peek() {
        if (isEmpty()) {   // If empty, nothing to peek
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];  // Return front element
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Print the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        // Print elements circularly from front to rear
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " || ");
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        Circularqueue queue = new Circularqueue(5); // Create queue of size 5

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.printQueue(); // 5 || 10 || 15 || 20 || 25 || null

        queue.enqueue(30);  // Queue is full!

        System.out.println("Dequeued: " + queue.dequeue()); // Removes 5
        queue.printQueue(); // 10 || 15 || 20 || 25 || null

        queue.enqueue(30); // Reuses space (circularly)
        queue.printQueue(); // 10 || 15 || 20 || 25 || 30 || null

        System.out.println("Front element: " + queue.peek()); // 10
    }
}
