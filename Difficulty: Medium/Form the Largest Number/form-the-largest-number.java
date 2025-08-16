
// User function Template for Java

import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // Convert int[] to String[]
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Sort using custom comparator
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare concatenated results
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab); // descending order
            }
        });

        // If the largest number is "0", return "0" (handle cases like [0,0])
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Build final result
        StringBuilder result = new StringBuilder();
        for (String s : strArr) {
            result.append(s);
        }

        return result.toString();
    }
}
