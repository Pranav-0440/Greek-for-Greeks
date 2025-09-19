class Solution {
    int transform(String A, String B) {
        // Step 1: If lengths differ, impossible
        if (A.length() != B.length()) return -1;
        
        int n = A.length();
        
        // Step 2: Check if both have same frequency of characters
        int[] count = new int[256]; // ASCII
        for (int i = 0; i < n; i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
        for (int c : count) {
            if (c != 0) return -1; // mismatch
        }
        
        // Step 3: Match from end
        int i = n - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                j--;
            }
            i--;
        }
        
        // j+1 chars matched at end
        return j + 1;
    }
}
