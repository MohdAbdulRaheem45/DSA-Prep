import java.util.Stack;

public class ImplementQueueUsingStacks {
    private Stack<Integer> instack;
    private Stack<Integer> outstack;
    ImplementQueueUsingStacks(){
        instack=new Stack<>();
        outstack=new Stack<>();
    }
    public void push(int value){
        instack.push(value);
    }
    public int pop(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.pop();
    }
    public int peek(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.peek();

    }
    public boolean isEmpty(){
        return instack.isEmpty() && outstack.isEmpty();
    }
}
