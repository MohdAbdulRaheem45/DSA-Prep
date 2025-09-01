public class MaxprodOptimized {
    public static void main(String[] args) {
        int[] arr={4,2,5,1};
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1){
                max2=max1;
                max1=arr[i];
            }else if(arr[i]>max2){
                max2=arr[i];
            }
        }
        int prod=max1*max2;
        System.out.println(prod);
    }
    
}
