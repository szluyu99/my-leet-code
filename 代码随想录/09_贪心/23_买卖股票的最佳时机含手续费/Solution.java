// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// 动态规划
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] sell = new int[n]; // 第 i 天卖股票的最高利润
        int[] buy = new int[n]; // 第 i 天买股票的最高利润 
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天卖股票的最高利润: [卖] 或 [不卖] 两种行为做比较
            // [卖]: 之前买的最高利润 + 今天卖的钱 - 手续费
            // [不卖]: 之前卖过的最高利润
            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
            // 今天买股票的最高利润: [买] 或 [不买] 两种行为做比较
            // [买]: 之前卖的最高利润 - 今天买的钱
            // [不买]: 之前买过的最高利润
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
        }
        return sell[n - 1];
    }
}