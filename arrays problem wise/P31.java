public class P31 {//roate by 90 degree
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Step 1: Transpose the matrix
     for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr[0].length;j++){
            int temp=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=temp;
        }
     }
     for(int i=0;i<arr.length;i++){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[i][left];
            arr[i][left]=arr[i][right];
            arr[i][right]=temp;
            left++;
            right--;
        }
     }

        // Print the rotated matrix
        System.out.println("Matrix after 90° rotation:");
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
