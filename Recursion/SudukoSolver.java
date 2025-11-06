// 🔹 Time Complexity: O(9^(N*N))  -> For every empty cell, we try digits 1–9
// 🔹 Space Complexity: O(N*N)     -> Recursion + board storage (N = 9)

class Solution {
    // Function to check if placing digit is safe
    public static boolean isSafe(int row, int col, char digit, char[][] board) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }

        // Check the 3x3 subgrid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }
        return true;
    }

    // Recursive backtracking function
    public static boolean solve(int row, int col, char[][] board) {
        // ✅ If we’ve reached past the last row, Sudoku is solved
        if (row == 9) return true;

        // Compute next cell coordinates
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip prefilled cells
        if (board[row][col] != '.') {
            return solve(nextRow, nextCol, board);
        }

        // Try placing digits 1–9
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(row, col, digit, board)) {
                board[row][col] = digit;  // place digit

                if (solve(nextRow, nextCol, board)) return true; // solved path found

                board[row][col] = '.';    // ❌ backtrack (undo)
            }
        }

        // No valid digit possible
        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
}
