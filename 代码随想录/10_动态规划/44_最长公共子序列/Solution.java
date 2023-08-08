// https://leetcode.cn/problems/longest-common-subsequence/
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        // dp[i][j] s1 中 [0..i] 和 s2 中 [0..j] 的公共子序列长度
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i - 1] == cs2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}