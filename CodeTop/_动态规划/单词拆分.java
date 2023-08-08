package CodeTop._动态规划;

import java.util.List;

// https://leetcode.cn/problems/word-break/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示字符串 s 的前 i 个字符能否拆分成 wordDict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}