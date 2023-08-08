// https://leetcode.cn/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        char [] cs = s.toCharArray(), ct = t.toCharArray();
        int j = 0;
        for (int i = 0; i < ct.length; i++) {
            if (cs[j] == ct[i]) j++;
            if (j == cs.length) return true;
        }
        return false;
    }
}

class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        // dp[i][j] s 中 [0..i] 的串和 t 中 [0..j] 的串的公共子序列的长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++)
            for (int j = 1; j <= l2; j++)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];

        return dp[l1][l2] == s.length();
    }
}