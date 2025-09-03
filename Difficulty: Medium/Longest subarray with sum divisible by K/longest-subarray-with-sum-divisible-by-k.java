import java.util.*;

class Solution {
    int longestSubarrayDivK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        // Map remainder -> first index where this remainder occurred
        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1); // prefix sum 0 at index -1

        long prefixSum = 0L;   // use long to avoid overflow
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Normalize remainder to be between 0 and k-1
            int rem = (int)((prefixSum % k + k) % k);

            if (firstIndex.containsKey(rem)) {
                int length = i - firstIndex.get(rem);
                if (length > maxLen) maxLen = length;
            } else {
                // store first occurrence only
                firstIndex.put(rem, i);
            }
        }
        return maxLen;
    }
}
