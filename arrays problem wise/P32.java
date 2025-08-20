public class P32 {//roate by 90 degree  anti clock wise
    public static void main(String[] args) {
        int a[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Step 1: Transpose
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Step 2: Reverse columns
        for (int i = 0; i < a.length; i++) {
            int top = 0;
            int bottom = a.length - 1;
            while (top < bottom) {
                int temp = a[top][i];
                a[top][i] = a[bottom][i];
                a[bottom][i] = temp;
                top++;
                bottom--;
            }
        }

        // Print rotated matrix
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
