class Solution {
    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[len];
        dp[0] = 0;
        int min = prices[0]; 
        for (int i = 1; i < len; i++) {
            if (prices[i] < min)
                min = prices[i];
            // 状态转移方程
            dp[i] = Math.max(dp[i-1], prices[i] - min);
        }
        return dp[len - 1];
    }
    /**
     * 动态规划优化 - 使用一个变量即可记录结果
     */
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i-1] < min) 
                min = prices[i-1];
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}