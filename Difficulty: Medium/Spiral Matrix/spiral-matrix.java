// User function Template for Java

class Solution {
    public int findK(int a[][], int n, int m, int k) {
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        int count = 0;

        while (top <= bottom && left <= right) {
            
            // Traverse top row
            for (int i = left; i <= right; i++) {
                count++;
                if (count == k) return a[top][i];
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                count++;
                if (count == k) return a[i][right];
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    count++;
                    if (count == k) return a[bottom][i];
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    count++;
                    if (count == k) return a[i][left];
                }
                left++;
            }
        }

        return -1; // just in case k is invalid
    }
}
