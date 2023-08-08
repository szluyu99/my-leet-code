/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 309. 最佳买卖股票时机含冷冻期
 */
class Solution {
    public int maxProfit(int[] prices) {
        // 持有股票
        int[] hold = new int[prices.length];
        hold[0] = -prices[0];
        // 未持有股票
        int[] notHold = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            // 最大收益 = [昨天持有的股票] 或 [之前卖出的最大收益 - 今天买入的]
            if (i >= 2) hold[i] = Math.max(hold[i - 1], notHold[i - 2] - prices[i]);
            // 最大收益 = [昨天持有的股票] 或 [今天买入的]
            else hold[i] = Math.max(hold[i - 1], -prices[i]);
            // 最大收益 = [昨天的最大收益] 或 [昨天买入 + 今天卖出]
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
        }
        return notHold[prices.length - 1];
    }
}