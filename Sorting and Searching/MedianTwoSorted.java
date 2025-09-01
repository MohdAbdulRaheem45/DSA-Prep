public class MedianTwoSorted {
    public static int median(int arr1[],int arr2[]){
        int m=arr1.length;
        int n=arr2.length;
        int i=0;
        int j=0;
        int k=0;
        int merged[]=new int[n+m];
        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){
                merged[k++]=arr1[i++];
            }else{
                merged[k++]=arr2[j++];
            }
        }
        while(i<m) merged[k++]=arr1[i++];
        while(j<n) merged[k++]=arr2[j++];
        int total=n+m;
        if(total%2==1){
            return merged[total/2];
        }else{
            return ((merged[total/2 - 1]+merged[total/2])/2);
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,2};
        int arr2[]={3};
        System.out.println(median(arr1,arr2));
    }
    
}
