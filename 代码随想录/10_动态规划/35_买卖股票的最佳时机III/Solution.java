// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // sell[i][j] 在第 i 天不持股(当天或之前卖出)的最大利润, 当前是第 j 笔交易
        int[][] sell = new int[n][3];
        // buy[i][j] 在第 i 天持股(当天或之前买入)的最大利润, 当前是第 j 笔交易
        int[][] buy = new int[n][3];
        for (int i = 0; i < 3; i++)
            buy[0][i] = -prices[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                // 卖的必须是当前轮买的
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
                // 买之前必须在上一轮卖掉
                buy[i][j] = Math.max(buy[i - 1][j], sell[i- 1][j - 1] - prices[i]);
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) max = Math.max(max, sell[n - 1][i]);
        return max;
    }
}