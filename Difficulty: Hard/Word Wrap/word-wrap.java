class Solution {
    public int solveWordWrap(int[] arr, int k) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        // Precompute cost[i][j] = cost of putting words i..j in one line
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            int lineLength = -1; // -1 because no space before first word
            for (int j = i; j < n; j++) {
                lineLength += arr[j] + 1; // word length + one space
                if (lineLength <= k) {
                    if (j == n - 1) {
                        cost[i][j] = 0; // last line has no penalty
                    } else {
                        int extraSpaces = k - lineLength;
                        cost[i][j] = extraSpaces * extraSpaces;
                    }
                } else {
                    cost[i][j] = INF;
                }
            }
        }

        // dp[i] = min cost for words[i..n-1]
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = INF;
        dp[n] = 0; // base case

        // Fill dp backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (cost[i][j] == INF) break;
                if (dp[j + 1] != INF) {
                    dp[i] = Math.min(dp[i], cost[i][j] + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}
