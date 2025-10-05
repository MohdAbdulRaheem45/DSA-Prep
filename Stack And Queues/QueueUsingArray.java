public class QueueUsingArray {
    int arr[];
    int front;
    int rear;
    int capacity;
    QueueUsingArray(int size){
        arr=new int[size];
        front=0;
        rear=-1;
        capacity=size;
    }
    public  void enqueue(int data){
        if(rear==capacity-1){
            System.out.println("full");
            return;
        }
        arr[++rear]=data;
        
    }
    public int  dequeue(){
        if(front>rear){
            System.out.println("empty");
            return 0;
        }
        int data=arr[front++];
        return data;
    }
    public int peek(){
        if(front>rear){
            System.out.println("empty");
        }
        return arr[front];
    }
    public void printqueue(){
        if(front>rear){
            System.out.println("empty");
        }
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+"||");
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        QueueUsingArray queue=new QueueUsingArray(5);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.printqueue();
        queue.enqueue(30);
        System.out.println("dequeed element: "+queue.dequeue());
        System.out.println("front element: "+queue.peek());
    }

    
}
