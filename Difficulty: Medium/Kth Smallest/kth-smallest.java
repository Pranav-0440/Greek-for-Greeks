// User function Template for Java
import java.util.*;
class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        Arrays.sort(arr);
        return arr[0+k-1];
        
    }
}
