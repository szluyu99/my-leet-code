package CodeTop._动态规划;

// https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/
class Solution {
    public int numWays(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}