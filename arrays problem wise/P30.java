public class P30 { // Spiral Order Matrix Traversal
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Loop until all layers are traversed
        while (top <= bottom && left <= right) {

            // 1. Traverse from Left ➝ Right (Top Row)
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++; // move top row down

            // 2. Traverse from Top ➝ Bottom (Right Column)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--; // move right column to left

            // 3. Traverse from Right ➝ Left (Bottom Row), only if rows are left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--; // move bottom row up
            }

            // 4. Traverse from Bottom ➝ Top (Left Column), only if columns are left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++; // move left column right
            }
        }
    }
}
