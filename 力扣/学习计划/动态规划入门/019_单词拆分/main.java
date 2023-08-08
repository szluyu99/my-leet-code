import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 139. 单词拆分
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示字符串 s 的前i个字符能否拆分成 wordDict
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        // dp[i]表示字符串 s 的前i个字符能否拆分成 wordDict
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        int maxWordLength = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            maxWordLength = Math.max(maxWordLength, wordDict.get(i).length());
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(i - maxWordLength, 0); j < i; j++) {
                if (valid[j] && wordDict.contains(s.substring(j, i))) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}