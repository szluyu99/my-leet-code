// https://leetcode-cn.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
        // dp[i] 以 i 位置元素结尾的解码方法的总数
        int[] dp = new int[s.length() + 1];
        // 初始化 dp
        dp[0] = 1; // dp[0] 无意义
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // 手动计算 dp[1]
        for (int i = 2; i <= s.length(); i++) {
            // 考虑单独解码(当前数字不为'0', dp[i] = dp[i-1])
            if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
            // 考虑组合解码(当前数字和上一位数字组合起来可以解码, dp[i] += dp[i-2])
            int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (t >= 10 && t <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()]   ;
    }
}