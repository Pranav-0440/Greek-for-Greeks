class Solution {
    int n, m;
    
    public char[][] fill(char[][] mat) {
        n = mat.length;
        m = mat[0].length;
        
        // Step 1: Mark safe 'O's from boundaries
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 'O') dfs(mat, i, 0);
            if (mat[i][m - 1] == 'O') dfs(mat, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 'O') dfs(mat, 0, j);
            if (mat[n - 1][j] == 'O') dfs(mat, n - 1, j);
        }
        
        // Step 2: Replace remaining 'O' -> 'X', restore safe '#' -> 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                } else if (mat[i][j] == '#') {
                    mat[i][j] = 'O';
                }
            }
        }
        return mat;
    }
    
    private void dfs(char[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] != 'O') return;
        
        mat[i][j] = '#'; // mark as safe
        
        dfs(mat, i + 1, j);
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i, j - 1);
    }
}
