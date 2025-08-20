public class P14 {//finding missing elemnnt apporch 1 by sum
    public static void main(String[] args) {
        int arr[]={1,2,3,5,6};
        int n=arr.length;
        int expectedsum=((n+1)*(n+2))/2;
        int totalsum=0;
        for(int i=0;i<n;i++){
             totalsum+=arr[i];
        }
        int missingnumber=expectedsum-totalsum;
        System.out.println(missingnumber);
    }
}
