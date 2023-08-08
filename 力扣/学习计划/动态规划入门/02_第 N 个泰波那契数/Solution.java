/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
class Solution {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        // dp[i] - 第 i 个泰波那契数列
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) 
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        return dp[n];
    }
}