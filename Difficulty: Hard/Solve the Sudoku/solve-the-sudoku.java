class Solution {
    // Check if placing a number is safe
    public boolean isSafe(int[][] mat, int row, int col, int num) {
        // Check in the same row and column
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num || mat[i][col] == num)
                return false;
        }

        // Check in the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (mat[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    // Recursive helper using backtracking
    public boolean solve(int[][] mat, int row, int col) {
        // Base case: reached beyond last cell
        if (row == 9)
            return true;

        // Compute next row & column
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell already filled, skip to next
        if (mat[row][col] != 0)
            return solve(mat, nextRow, nextCol);

        // Try all possible digits 1-9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(mat, row, col, num)) {
                mat[row][col] = num; // Place number

                if (solve(mat, nextRow, nextCol))
                    return true; // Continue if valid

                // Backtrack
                mat[row][col] = 0;
            }
        }

        return false; // No valid number found → backtrack
    }

    // Main function
    public void solveSudoku(int[][] mat) {
        solve(mat, 0, 0);
    }
}
