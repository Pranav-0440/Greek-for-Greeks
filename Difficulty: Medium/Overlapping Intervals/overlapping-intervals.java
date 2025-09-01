import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> result = new ArrayList<>();

        if (arr == null || arr.length == 0) return result;

        // Step 1: Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Add the first interval
        int[] current = arr[0];
        result.add(current);

        // Step 3: Iterate and merge if necessary
        for (int i = 1; i < arr.length; i++) {
            int[] next = arr[i];

            if (current[1] >= next[0]) {
                // Overlap → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → move to next
                current = next;
                result.add(current);
            }
        }

        return result;
    }
}
