public class P1 {//Maximum Sum Subarray of Size K
 public static void main(String[] args) {
    int[] arr={5,6,7,10,9};
    int maxsum=0;
    int k=3;
    for(int i=0;i<k;i++){
      maxsum+=arr[i];
    }
    int windowsum=maxsum;
    for(int i=k;i<arr.length;i++){
      windowsum+=arr[i]-arr[i-k];
      maxsum=Math.max(maxsum,windowsum);
    }
    System.out.println(maxsum);
 }   
}
