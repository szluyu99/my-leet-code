/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 746. 使用最小花费爬楼梯
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] 爬到第 i 层的最低花费
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++)
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        return dp[n];
    }
}