package CodeTop._动态规划;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i] 表示在第 i 天能获得的最大利益
        int[] dp = new int[n];

        int min = prices[0], max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if (dp[i] > max) max = dp[i];
            if (prices[i] < min) min = prices[i];
        }
        return max;
    }
}
