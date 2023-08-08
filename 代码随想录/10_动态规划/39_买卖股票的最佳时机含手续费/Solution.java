// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // buy[i] 第 i 天时买入股票的最大收益
        int[] buy = new int[n];
        // sell[i] 第 i 天时卖出股票的最大收益
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[n - 1];
    }
}