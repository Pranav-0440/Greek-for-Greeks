import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int hIndex(int[] citations) {
        // Convert the array to Integer array to sort in descending order
        Integer[] cit = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cit[i] = citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());
        
        int h = 0;
        for (int i = 0; i < cit.length; i++) {
            if (cit[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}