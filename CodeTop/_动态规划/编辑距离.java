package CodeTop._动态规划;

// https://leetcode.cn/problems/edit-distance/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // dp[i][j] 表示将 s1[0..n] 变成 s2[0..m] 需要的最少操作数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int i = 0; i <= m; i++) dp[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) { // 不需要进行操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // 需要进行操作: 取 添加, 删除, 修改 的最小值
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}