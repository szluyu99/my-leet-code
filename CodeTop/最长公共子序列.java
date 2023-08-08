package CodeTop;

// https://leetcode.cn/problems/longest-common-subsequence/

// dp[n+1][m+1]
class Solution0 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        int n = cs1.length, m = cs2.length;

        // dp[i][j] 表示 s1[0..i] 和 s2[0..j] 的最长公共子序列
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}

// dp[n][m]
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        int n = cs1.length, m = cs2.length;

        // dp[i][j] 表示 s1[0..i-1] 和 s2[0..j-1] 的最长公共子序列
        int[][] dp = new int[n][m];
        dp[0][0] = (cs1[0] == cs2[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (cs1[i] == cs2[0]) ? 1 : dp[i-1][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = (cs2[j] == cs1[0]) ? 1 : dp[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (cs1[i] == cs2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}