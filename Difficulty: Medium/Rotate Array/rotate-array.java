class Solution {
    void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n; // handle d >= n

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);
        // Step 2: Reverse remaining elements
        reverse(arr, d, n - 1);
        // Step 3: Reverse whole array
        reverse(arr, 0, n - 1);
    }

    // Helper to reverse subarray
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
