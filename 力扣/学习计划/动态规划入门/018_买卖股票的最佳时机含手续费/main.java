/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 714. 买卖股票的最佳时机含手续费
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0]; // 第 i 天手上持有股票的最大利润
        dp[0][1] = 0; // 第 i 天手上没有股票的最大利润
        for (int i = 1; i < prices.length; i++) {
            // 今天持股的最大利润 = 昨天持股今天不动 或 昨天不持股今天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 今天不持股的最大利润 = 昨天不持股不动 或 昨天持股今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}