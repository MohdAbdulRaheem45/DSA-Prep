import java.util.Stack;

public class LargestRecInHistogram {
    public static int[] rightsmaller(int heights[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[heights.length];
        for(int i=res.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();

            }
            if(stack.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        
        return res;
    }
    public static int[] leftsmaller(int heights[]){
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();

            }
            if(stack.isEmpty()){
                res[i]=heights.length;
            }else{
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int heights[]={2,1,5,6,2,3};
        int maxarea=0;
        int left[]=leftsmaller(heights);
        int right[]=rightsmaller(heights);
        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int area=heights[i]*width;
           
            maxarea=Math.max(maxarea, area);
            

        }
        System.out.println(maxarea);
    }
    
}
