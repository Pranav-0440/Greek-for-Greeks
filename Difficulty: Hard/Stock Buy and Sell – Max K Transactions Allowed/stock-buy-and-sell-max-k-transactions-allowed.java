class Solution {
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If transactions are more than possible trades, do simple greedy profit
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        // DP table: dp[t][d] → max profit up to day d with at most t transactions
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }
}
