public class P26 {//move negatives to end
    public static void main(String[] args) {
        int[] arr = {3, -2, -5, 4, 0, -1};
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]>=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;


            }

        }

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

