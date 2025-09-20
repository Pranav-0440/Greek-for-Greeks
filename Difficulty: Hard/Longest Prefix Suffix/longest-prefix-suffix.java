class Solution {
    int getLPSLength(String s) {
        int n = s.length();
        int[] lps = new int[n];   // prefix function array

        int len = 0;  // current longest prefix suffix length
        int i = 1;    // start comparing from second character

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[n - 1];  // result for full string
    }
}
