import java.util.*;

class Solution {

    // 🧩 Check if placing a queen at (row, col) is safe
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // 1️⃣ Check vertically upwards
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 2️⃣ Check upper-left diagonal ↖
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 3️⃣ Check upper-right diagonal ↗
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // ✅ Safe to place queen
    }

    // 🧠 Recursive helper function to place queens row by row
    public static void helper(int row, char[][] board, List<List<String>> result, int n) {
        // ✅ Base case: all rows filled → valid configuration
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] rows : board) {
                temp.add(new String(rows)); // convert char[] → String
            }
            result.add(temp); // store valid board
            return;
        }

        // 🔁 Try placing queen in each column of this row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';        // Place queen
                helper(row + 1, board, result, n); // Recurse for next row
                board[row][col] = '.';        // 🔙 Backtrack (remove queen)
            }
        }
    }

    // 🏁 Main function
    public List<List<String>> solveNQueens(int n) {
        // Create empty board (filled with '.')
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        List<List<String>> result = new ArrayList<>();

        // Start recursion from first row
        helper(0, board, result, n);

        return result;
    }
}
