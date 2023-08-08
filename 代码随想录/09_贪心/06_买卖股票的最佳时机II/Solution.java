// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
// 一维DP * 2
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n]; // buy[i] 第 i 天买能获得的最大利益
        int[] sell = new int[n]; // sell[i] 第 i 天卖能获得的最大利益
        buy[0] = -prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            max = Math.max(max, sell[i]); // 最大利益只会产生在卖的时候
        }
        return max;
    }
}

// 贪心
class Solution1 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) 
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        return res;
    }
}

// 二维 DP
class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0] - 第 i 天[买]能获得的最大利益
        // dp[i][1] - 第 i 天[卖]能获得的最大利益
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}