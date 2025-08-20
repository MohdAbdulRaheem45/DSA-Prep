public class P6 {//chk if array is sorted or not
    public static void main(String[] args) {
        int arr[]={1,2,2,6};
        int n=arr.length;
        boolean t=true;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                t=false;
                System.out.println("the array is not sorted");
                return;
            }
        }
        if(t){
        System.out.println("the array is sorted");
        }
    }
    
}
