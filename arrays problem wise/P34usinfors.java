public class P34usinfors {
    public static void main(String[] args) {
        int numRows = 5;
        int[][] pascal = new int[numRows][numRows]; // max size is numRows for each row

        for (int i = 0; i < numRows; i++) {
            pascal[i][0] = 1;      // first element = 1
            pascal[i][i] = 1;      // last element = 1

            // Fill middle values using formula
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

        // Print Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
