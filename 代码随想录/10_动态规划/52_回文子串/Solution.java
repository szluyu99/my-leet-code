import java.util.Arrays;

// https://leetcode.cn/problems/palindromic-substrings/class Solution {
// 双指针
class Solution {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        // dp[i] 以 s[i] 结尾的回文子串的数目
        int[] dp = new int[cs.length];
        for (int i = 0; i < cs.length; i++)
            for (int j = 0; j <= i; j++)
                if (isPalindrome(cs, j, i))
                    dp[i]++;
        return Arrays.stream(dp).sum();
    }

    boolean isPalindrome(char[] cs, int l, int r) {
        while (l < r)
            if (cs[l++] != cs[r--])
                return false;
        return true;
    }
}

// DP
class Solution1 {
    public int countSubstrings(String s) {
        // dp[i][j] [i..j] 的子串是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = cs.length - 1; i >= 0; i--)
            for (int j = i; j < cs.length; j++)
                // 由状态转移方程可知, 每一个位置的更新取决于左下角位置的状态值
                // 所以外层循环从下往上, 内层从左往右
                if (cs[i] == cs[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
        return res;
    }
}

// 中心扩散
// 1. 遍历每一个字符，并以其为中点计算奇数长度和偶数长度的回文的长度
// 2. 中点开始扩散，当左右一致时代表一组新的回文, 直到左右不一样或者到达边界
class Solution2 {
    int res = 0;

    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count(cs, i, i); // 回文串长度为奇数
            count(cs, i, i + 1); // 回文串长度为偶数
        }
        return res;
    }

    void count(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            res++;
            l--;
            r++;
        }
    }
}