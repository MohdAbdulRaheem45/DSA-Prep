import java.util.Stack;

public class NGE2A {
    public static void main(String[] args) {
        int arr[]={1,2,1};
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=2*arr.length-1;i>=0;i--){
            int index=i%arr.length;
            while(!stack.isEmpty() && stack.peek()<=arr[index]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[index]=-1;
            }else{
                res[index]=stack.peek();
            }
            stack.push(arr[index]);

        }
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
