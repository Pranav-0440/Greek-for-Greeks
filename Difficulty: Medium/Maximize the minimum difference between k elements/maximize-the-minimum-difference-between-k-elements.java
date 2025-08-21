import java.util.*;

class Solution {
    public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr); // Step 1: Sort the array
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(arr, k, mid)) {
                result = mid; // this min diff is possible
                low = mid + 1; // try larger diff
            } else {
                high = mid - 1; // try smaller diff
            }
        }
        return result;
    }

    // Helper function: Check if we can place k elements with at least "dist" apart
    private boolean canPlace(int[] arr, int k, int dist) {
        int count = 1; // pick first element
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
                if (count >= k) return true;
            }
        }
        return false;
    }
}
