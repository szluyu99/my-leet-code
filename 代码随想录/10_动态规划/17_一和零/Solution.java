// https://leetcode.cn/problems/ones-and-zeroes/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[i][j][k] 在前 i 个字符串中, 0 的个数 <= m, 1 的个数 <= n, 的字符串的个数
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int n_1 = getOneNum(strs[i]); // 1 的数量
                    int n_0 = len - n_1; // 0 的数量
                    if (n_0 > m || n_1 > n) dp[i][j][k] = dp[i - 1][j][k];
                    else dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - n_0][k - n_1]);
                }
            }
        }
        return dp[len][m][n];
    }

    // 获取字符中 '1' 的个数
    int getOneNum(String s) {
        int cnt = 0;
        for (char c : s.toCharArray())
            if (c == '1') cnt++;
        return cnt;
    }
}

class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[i][j][k] 在前 i 个字符串中, 使用 j 个 0, k 个 1, 的字符串的个数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int n_1 = getOneNum(strs[i - 1]); // 1 的数量
            int n_0 = strs[i - 1].length() - n_1; // 0 的数量
            for (int j = m; j >= n_0; j--)
                for (int k = n; k >= n_1; k--) 
                    dp[j][k] = Math.max(dp[j][k], dp[j - n_0][k - n_1] + 1);
        }
        return dp[m][n];
    }

    // 获取字符中 '1' 的个数
    int getOneNum(String s) {
        int cnt = 0;
        for (char c : s.toCharArray())
            if (c == '1') cnt++;
        return cnt;
    }
}