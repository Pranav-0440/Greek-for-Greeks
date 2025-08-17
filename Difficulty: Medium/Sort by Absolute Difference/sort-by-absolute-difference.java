import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert array to list for custom sorting
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Sort by absolute difference with x
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int diffA = Math.abs(a - x);
                int diffB = Math.abs(b - x);

                if (diffA != diffB) {
                    return diffA - diffB; // smaller difference first
                } else {
                    return 0; // keep original order (stable sort)
                }
            }
        });

        // Copy back sorted list into array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}
