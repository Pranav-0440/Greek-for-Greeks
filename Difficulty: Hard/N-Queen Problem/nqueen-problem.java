import java.util.*;

class Solution {
    // Function to check if placing a queen at (row, col) is safe
    public static boolean isSafe(char[][] board, int row, int col) {
        // Check vertically upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true; // Safe to place
    }
    
    // Recursive backtracking function
    public static void solve(char[][] board, int row, ArrayList<ArrayList<Integer>> result) {
        if (row == board.length) {
            // Base case: all queens placed, record the solution
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 'Q') {
                        temp.add(j + 1); // storing column (1-based)
                    }
                }
            }
            result.add(temp);
            return;
        }
        
        // Try placing a queen in each column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';        // Place queen
                solve(board, row + 1, result); // Move to next row
                board[row][j] = '.';        // Backtrack
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        
        // Start backtracking from row 0
        solve(board, 0, result);
        return result;
    }
}
