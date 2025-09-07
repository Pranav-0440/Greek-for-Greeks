class Solution {
    public String printSequence(String S) {
        // Map of characters to keypad sequence
        String[] keypad = {
            "2", "22", "222",     // A, B, C
            "3", "33", "333",     // D, E, F
            "4", "44", "444",     // G, H, I
            "5", "55", "555",     // J, K, L
            "6", "66", "666",     // M, N, O
            "7", "77", "777", "7777", // P, Q, R, S
            "8", "88", "888",     // T, U, V
            "9", "99", "999", "9999"  // W, X, Y, Z
        };
        
        StringBuilder result = new StringBuilder();
        
        for (char ch : S.toCharArray()) {
            if (ch == ' ') {
                result.append("0"); // space maps to 0
            } else {
                // find index: 'A' → 0, 'B' → 1 ... 'Z' → 25
                int index = ch - 'A';
                result.append(keypad[index]);
            }
        }
        
        return result.toString();
    }
}
