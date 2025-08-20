public class P11 {//leader in arrays:an elenemt ehihc graeter than the elemnts on its right
    public static void main(String[] args) {
        int arr[]={16,17,5,6,2};
        int n=arr.length;
        int maxrght=arr[n-1];//taking last as leader at first
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxrght){
                maxrght=arr[i];
                System.out.println(maxrght);
            }
        }
    }
    
}
