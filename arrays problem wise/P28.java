public class P28 {//0s,1s,2s dutch national flag problem
    public static void main(String[] args) {
        int arr[]={2,1,0,0,0,1,2,1,0};
        int n=arr.length;
        int low=0;// for 0s
        int high=n-1;//for 2s
        int mid=0;//for tracking current element
        while(mid<=high){
if(arr[mid]==0){
    int temp=arr[mid];
    arr[mid]=arr[low];
    arr[low]=temp;
    low++;
    mid++;

}
else if(arr[mid]==1){
    mid++;
}else if(arr[mid]==2){
    int temp=arr[mid];
    arr[mid]=arr[high];
    arr[high]=temp;
    high--;
}

        }
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }}}
    

