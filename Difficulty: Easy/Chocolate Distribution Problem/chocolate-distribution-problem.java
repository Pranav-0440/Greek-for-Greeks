// User function Template for Java

import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        if (m == 0 || n == 0) return 0;
        if (m > n) return -1; // Not enough packets

        // Sort the packets
        Collections.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        // Find the minimum difference among windows of size m
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
    
}
