class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // Total flowers required
        long total = (long) m * k;
        if (total > arr.length) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : arr) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(arr, k, m, mid)) {
                ans = mid;
                high = mid - 1; // try earlier day
            } else {
                low = mid + 1; // need more days
            }
        }
        return ans;
    }

    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int bouquets = 0, flowers = 0;
        for (int bloom : arr) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // reset after making bouquet
                }
            } else {
                flowers = 0; // break in consecutive flowers
            }
            if (bouquets >= m) return true;
        }
        return false;
    }
}
