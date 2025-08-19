import java.util.*;

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        // Step 1: Build suffix minimum array
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }
        
        // Step 2: For each element, binary search farthest smaller
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            int ans = -1;
            
            while (low <= high) {
                int mid = (low + high) / 2;
                
                if (suffixMin[mid] < arr[i]) {
                    ans = mid;       // possible answer
                    low = mid + 1;  // try to go farther
                } else {
                    high = mid - 1;
                }
            }
            res.add(ans);
        }
        
        return res;
    }
}
