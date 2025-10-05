import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueue {
    private Queue<Integer> queue;
    ImplementStackusingQueue(){
        queue=new LinkedList<>();

    }
    public void push(int data){
        queue.add(data);
        int size=queue.size();
        for(int i=0;i<size-1;i++){
            queue.add(queue.remove());
        }
    }
    public void peek(){
        queue.peek();
    }
    public void pop(){
        queue.poll();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
}
