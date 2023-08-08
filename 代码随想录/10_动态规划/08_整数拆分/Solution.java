// https://leetcode.cn/problems/integer-break/
class Solution {
    public int integerBreak(int n) {
        // dp[i] 整数 i 的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // dp[j] * (i - j) 前 j 长度进行拆分的最大乘积
                // j * (i - j) 前 j 长度不进行拆分的最大乘积
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}