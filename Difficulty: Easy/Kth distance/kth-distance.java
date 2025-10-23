import java.util.*;

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // Using a HashSet to track elements in the current window of size k
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If current element already exists in set => duplicate found within k distance
            if (seen.contains(arr[i])) {
                return true;
            }

            // Add current element to set
            seen.add(arr[i]);

            // Maintain window size of k
            if (seen.size() > k) {
                seen.remove(arr[i - k]); // Remove element that goes out of window
            }
        }

        // If loop ends without finding duplicates
        return false;
    }
}
