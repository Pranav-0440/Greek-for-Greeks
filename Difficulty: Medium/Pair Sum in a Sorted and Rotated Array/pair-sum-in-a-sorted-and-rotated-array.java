class Solution {
    public boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;

        // Step 1: find pivot (smallest element index)
        int pivot = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i + 1;
                break;
            }
        }

        // Step 2: left = smallest, right = largest
        int l = pivot;          // smallest
        int r = (pivot - 1 + n) % n;  // largest

        // Step 3: loop until two pointers meet
        while (l != r) {
            int sum = arr[l] + arr[r];

            if (sum == target) {
                return true;
            }

            if (sum < target) {
                l = (l + 1) % n;   // move right circularly
            } else {
                r = (n + r - 1) % n; // move left circularly
            }
        }

        return false;
    }

}
