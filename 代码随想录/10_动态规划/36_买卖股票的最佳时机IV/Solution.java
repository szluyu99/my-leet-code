// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/submissions/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // sell[i][j] 在第 i 天不持股(当天或之前卖出)的最大利润, 当前是第 j 笔交易
        int[][] sell = new int[n][k + 1];
        // buy[i][j] 在第 i 天持股(当天或之前买入)的最大利润, 当前是第 j 笔交易
        int[][] buy = new int[n][k + 1];
        for (int i = 0; i < k + 1; i++) buy[0][i] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
            }
        }
        
        int max = 0;
        for (int i = 0; i < k + 1; i++) max = Math.max(max, sell[n - 1][i]);
        return max;
    }
}