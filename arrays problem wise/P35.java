public class P35 {//trapping rain water
    public static void main(String[] args) {
        int[] height = {4,3,2,1,0,5};
        int n = height.length;

        int leftmax[]=new int[height.length];
        int rightMax[]=new int[height.length];
        
        leftmax[0]=height[0]; 
        for(int i=1;i<height.length;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        int trapped=0;
        for(int i=0;i<height.length;i++){
            trapped+=Math.min(leftmax[i],rightMax[i])-height[i];
        }

        System.out.println("Total trapped water: " + trapped);
    }
}
