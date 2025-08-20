public class P4 {//moving zeroes toend
    public static void main(String[] args) {
        int[] arr={0,0,2,3,1};
         int pos=0;
         for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[pos]=arr[i];
                pos++;

            }
         }
         while (pos<arr.length) {
            arr[pos]=0;
            pos++;
         }
         for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
         }
    }

    
}
