import java.util.Stack;
import java.util.Arrays;

public class P27 {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() &&stack.peek()<=arr[i]){
                stack.pop();

            }
            if(stack.isEmpty()){
                result[i]=-1;

            }
            else{
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] nge = nextGreaterElements(arr);
    

        System.out.println("Next Greater Elements: " + Arrays.toString(nge));
    }
}
