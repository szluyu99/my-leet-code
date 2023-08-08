import java.util.List;

// https://leetcode.cn/problems/word-break/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] s 的前 i 个字符能否拆分成 wordDict
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (wordDict.contains(s.substring(j, i)) && dp[j])
                    dp[i] = true;
        return dp[s.length()];
    }
}