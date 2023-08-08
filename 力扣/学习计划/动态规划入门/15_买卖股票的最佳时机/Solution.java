// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
// DP
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
// 贪心
class Solution1 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]); // 维护前面见过的最小值
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}