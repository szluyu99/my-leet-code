// https://leetcode.cn/problems/distinct-subsequences/
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        char[] cs = s.toCharArray(), ct = t.toCharArray();

        // dp[i][j] s[0..i] 和 t[0..j] 的子序列的个数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j > i) continue;     
                // 对如 s = "rara", t = "ra", i = 3, j = 1
                // 此时 s[i] == t[j], 分成两种情况: 
                // 1. s 用最后一位 "a": 此时序列相当于 "rar" 和 "r", dp[i - 1][j - 1] 
                // 2. 不用最后一位 "a": 此时序列相当于 "rar" 和 "ra", dp[i - 1][j]
                if (cs[i - 1] == ct[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                // 对如 s = "rarb", t ="ra", i = 3, j = 1
                // 此时 s[i] != t[j], 只有一种情况： 
                // 1. 不用最后一位 "b": 此时序列相当于 "rar" 和 "ra" : dp[i - 1][j]
                else 
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}