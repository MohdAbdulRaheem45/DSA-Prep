public class CountElements {
    public static void main(String[] args) {
        int[] arr={2,4,4,4,6,8};
        int target=4;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                count++;

            }
        }
        System.out.println(count);
    }
    
}
