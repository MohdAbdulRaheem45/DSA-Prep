public class P15 {//finding elemnet appearing only once
   
    public static void main(String[] args) {
        int arr[]={1,2,1,2,5};
        int n=arr.length;
        int xor1=0;
       
        for(int i=0;i<n;i++){
            xor1^=arr[i];
        }
        System.out.println(xor1);
       
    
    
}}
    

