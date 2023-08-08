package CodeTop.最长回文子串;

// https://leetcode.cn/problems/longest-palindromic-substring/
// 中心扩散
class Solution {
    String res = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i); // 处理奇数长度的回文串
            helper(s, i, i + 1); // 处理偶数长度的回文串
        }
        return res;
    }

    void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            String t = s.substring(l, r + 1);
            if (t.length() > res.length()) res = t;
            l--;
            r++;
        }
    }
}

