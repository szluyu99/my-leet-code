package _动态规划;
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
// 贪心
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0]; // 最低股价
        int max = 0; // 最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                max += prices[i] - min;
                min = prices[i];
            }
            if (prices[i] < min) min = prices[i];
        }
        return max;
    }
}

// DP
class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // buy[i] 表示在第 i 天持有股票的最大利润
        int[] hold = new int[n];
        hold[0] = -prices[0];
        // sell[i] 表示在第 i 天不持有股票的最大利润
        int[] noHold = new int[n];

        int max = 0;
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], noHold[i - 1] - prices[i]);
            noHold[i] = Math.max(noHold[i - 1], hold[i - 1] + prices[i]);
            max = Math.max(max,  noHold[i]);
        }

        return max;
    }
}