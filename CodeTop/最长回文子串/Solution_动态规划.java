package CodeTop.最长回文子串;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        // dp[i][j] 表示 s[i..j] 是否是回文子串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;

        int l = 0, r = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 长度 <= 2 必然是回文串, 如 "a", "bb"
                    if (j - i < 2) dp[i][j] = true;
                    // 长度 > 2 要看其子串是否是回文串, 对于 "abba" 则 "bb" 是回文串
                    else dp[i][j] = dp[i+1][j-1];

                    // 记录最长回文串 
                    if (dp[i][j] && r - l < j - i) {
                        r = j;
                        l = i;
                    }
                }
            }
        }

        return s.substring(l, r + 1);
    }   
}
