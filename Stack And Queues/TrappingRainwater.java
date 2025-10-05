public class TrappingRainwater {
    public static void main(String[] args) {
        int height[]={7,8,5,3,2,1};
        int l=0;
        int leftmax=0;int rightmax=0;int total=0;
        int r=height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(leftmax>height[l]){
                    total+=leftmax-height[l];

                }else{
                    leftmax=height[l];
                }
                l++;

            }else{
                 if(rightmax>height[r]){
                    total+=rightmax-height[r];

                }else{
                    rightmax=height[r];
                }
                r--;
            }
        }
        System.out.println(total);

    }
    
}
