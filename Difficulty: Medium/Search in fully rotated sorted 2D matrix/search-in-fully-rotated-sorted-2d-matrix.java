public class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = n * m - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / m;
            int j = mid % m;
            int midVal = mat[i][j];
            
            if (midVal == x) {
                return true;
            }
            
            if (mat[0][0] <= midVal) {
                // Left part is sorted
                if (x < mat[0][0] || x > midVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // Right part is sorted
                if (x < midVal || x > mat[n-1][m-1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}