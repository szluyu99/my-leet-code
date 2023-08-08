// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
// DP
class Solution {
public int maxProfit(int[] prices) {
    int n = prices.length;
    // buy[i] 在第 i 天买入股票的最大利润
    int[] buy = new int[n];
    buy[0] = -prices[0];
    // sell[i] 在第 i 天卖出股票的最大利润
    int[] sell = new int[n];

    for (int i = 1; i < n; i++) {
        // 选择: [不买] 或 [买]
        buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        // 选择: [不卖] 或 [卖]
        sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    }

    return sell[n - 1];
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