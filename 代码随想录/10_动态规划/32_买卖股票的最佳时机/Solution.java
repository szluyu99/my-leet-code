// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i] 第 i 天卖出股票能获取的最大利润
        int[] dp = new int[prices.length];
        // min 记录 i 之前天数的最大值
        int min = prices[0], res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            dp[i] = prices[i] - min; // 今天的利润
            res = Math.max(res, dp[i]);
        }
        return res; 
    }
}