public class Solution {

    // Binary Search Function: Find index of k
    public static int binarysearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                // Optional: return first occurrence
                while (mid > 0 && arr[mid - 1] == k) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}    