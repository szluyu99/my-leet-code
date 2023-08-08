class Solution {
    public int maxProfit(int[] prices) {
        // sell[i]表示截至第i天，最后一个操作是卖时的最大收益
        int[] sell = new int[prices.length];
        // buy[i]表示截至第i天，最后一个操作是买时的最大收益
        int[] buy = new int[prices.length];
        buy[0] = -prices[0];
        // cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益
        int[] cool = new int[prices.length];
        // 递推
        for (int i = 1; i < prices.length; i++) {
            // 最大收益 = [在第 i 天卖获得的收益（需计算）] 或者 [在 i 天之前就卖出的收益（无需计算）]
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], cool[i - 1]));
        }
        return sell[prices.length - 1];
    }
}