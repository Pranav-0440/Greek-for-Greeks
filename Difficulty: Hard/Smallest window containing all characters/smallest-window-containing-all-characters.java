class Solution {
    public String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // build frequency map for p
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int required = p.length();  // total chars needed
        int formed = 0;             // total chars matched
        int left = 0, minLen = Integer.MAX_VALUE, start = -1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // include current char in window
            freqS[c - 'a']++;

            // count towards formed if this char doesn't exceed needed
            if (freqS[c - 'a'] <= freqP[c - 'a']) {
                formed++;
            }

            // contract window if all chars matched
            while (formed == required) {
                // update smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // try shrinking
                char leftChar = s.charAt(left);
                freqS[leftChar - 'a']--;

                if (freqS[leftChar - 'a'] < freqP[leftChar - 'a']) {
                    formed--;
                }

                left++;
            }
        }

        return (start == -1) ? "" : s.substring(start, start + minLen);
    }
}
