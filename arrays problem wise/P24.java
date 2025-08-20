public class P24 {//second smallest in an array
    public static void main(String[] args) {
        int arr[]={1,7,2,8,5};
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min1){
                min2=min1;
                min1=arr[i];
            }else if(arr[i]<min2 && arr[i]!=min1){
                min2=arr[i];
            }
        }if(min2==Integer.MAX_VALUE){
            System.out.println("no second smallest element");
        }else{
        System.out.println("second smallest element is:"+min2);
    }}
    
}
