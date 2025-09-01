public class MaxProductAndKTHLARGEST{
    public static void main(String[] args) {
        int[] arr={4,2,5,1};
        int n=arr.length;
        int k=2;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        int max1=arr[n-1];
        int max2=arr[n-2];
        int kthlergest=arr[n-k];
        int maxprod=max1*max2;
        System.out.println(maxprod);
        System.out.println(kthlergest);

    }
    
}
