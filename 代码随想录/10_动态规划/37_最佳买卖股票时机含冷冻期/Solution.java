// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // sell[i] 第 i 天卖出的最大收益
        int[] sell = new int[n];
        // buy[i] 第 i 天买入的最大收益
        int[] buy = new int[n];
        // cool[i] 第 i 天冷冻的最大收益
        int[] cool = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 不买 或 买(只能在冷冻期过后买)
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
            // 不卖 或 卖
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            // 冷冻期只会由昨天卖出得到
            cool[i] = sell[i - 1];
        }
        return Math.max(sell[n - 1], cool[n - 1]);
    }
}