class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // 不持有股票, 今天没卖出
        dp[0][1] = 0; // 不持有股票, 今天卖出
        dp[0][2] = -prices[0]; // 持有股票, 今天买入的
        dp[0][3] = -prices[0]; // 持有股票, 非今天买入
        for (int i = 1; i < prices.length; i++) {
            // 前一天不持股的两种情况的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 今天卖出股票, 前一天持有的股票的最大值 + 今天的价格
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3]) + prices[i];
            // 今天买入股票, 前一天一定没有卖出股票
            dp[i][2] = dp[i - 1][0] - prices[i];
            // 今天没有买股票, 却持有股票, 前一天继承过来的
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
        }
        // 最大值一定是处于不持有股票的状态
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}