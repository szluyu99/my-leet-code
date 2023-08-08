// https://leetcode.cn/problems/delete-operation-for-two-strings/
class Solution {
    public int minDistance(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        // dp[i][j] 删除字符使得 s1 [0..i] 和 s2 [0..j] 相同的最小步数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int i = 0; i <= m; i++) dp[0][i] = i;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (cs1[i - 1] == cs2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
        return dp[n][m];
    }
}

// 求出两个字符串的最长公共子序列长度，除此之外的字符都需要删除
class Solution1 {
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        // dp[i][j] s1 [0..i] 和 s2 [0..j] 的最长公共子序列的长度
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= m; j++)
                if (cs1[i - 1] == cs2[j - 1]) 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        return m + n - dp[n][m] * 2;
    }
}