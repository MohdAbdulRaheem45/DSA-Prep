import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int arr[]={1,5,3,-8,-9,0,4,5};
        int n=arr.length;
        int k=3;
        Deque<Integer> dq=new LinkedList<>();
        int result[]=new int[n-k+1];
        for(int i=0;i<arr.length;i++){
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                result[i-k+1]=arr[dq.peekFirst()];
            }
        }
        for(int num:result){
            System.out.println(num);
        }
    }
    
}
