class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;   // because array size is n-1
        long totalSum = (long) n * (n + 1) / 2;  // expected sum of 1..n
        long arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        return (int)(totalSum - arrSum);
    }
}
