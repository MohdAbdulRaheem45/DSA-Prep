public class P142 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n=arr.length;
        int xor1=0;
        int xor2=0;
        for(int i=0;i<n;i++){
            xor1^=arr[i];
        }
        for(int i=1;i<=n+1;i++){
            xor2^=i;
        }
        System.out.println("misiing element: "+(xor1^xor2));
    }
    
    
}
