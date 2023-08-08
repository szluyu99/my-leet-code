// https://leetcode.cn/problems/perfect-squares/
class Solution {
    public int numSquares(int n) {
        // dp[i] 和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i * i <= n; i++) // 物品
            for (int j = 1; j <= n; j++) { // 背包
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        return dp[n];
    }
}