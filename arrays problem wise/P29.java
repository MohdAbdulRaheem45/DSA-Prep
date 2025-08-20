public class P29 { // set zeroes in the matrix (2D)
    public static void main(String[] args) {
        int arr[][] = {
            {1, 1, 0},
            {1, 1, 1},
            {1, 1, 1}
        };

        boolean firstrowzero = false;
        boolean firstcolzero = false;

        // Step 1: Check if first column has any 0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                firstcolzero = true;
            }
        }

        // Step 2: Check if first row has any 0
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] == 0) {
                firstrowzero = true;
            }
        }

        // Step 3: Mark zeroes in first row & column
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Step 4: Update inner matrix based on marks
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Step 5: Handle first column
        if (firstcolzero) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

        // Step 6: Handle first row
        if (firstrowzero) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[0][j] = 0;
            }
        }

        // ✅ Step 7: Print the matrix (Bug fixed here: j++ instead of i++)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
