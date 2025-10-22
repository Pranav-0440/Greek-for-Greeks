import java.util.*;

class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Build prefix sum array
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        // Step 2: Min-heap to store top k sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 3: Generate all subarray sums
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];

                // Maintain heap of size k
                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll();  // remove smallest
                    minHeap.add(sum);
                }
            }
        }

        // Step 4: The top of the heap is the K-th largest sum
        return minHeap.peek();
    }
}    