// https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
// API
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, 2);
    }
}

// char[] 反转 3 次
class Solution1 {
    public String reverseLeftWords(String s, int n) {
        char[] cs = s.toCharArray();
        int len = s.length();
        reverse(cs, 0, n - 1);
        reverse(cs, n, len - 1);
        reverse(cs, 0, len - 1);
        return new String(cs);
    }
    void reverse(char[] cs, int i, int j) {
        while (i < j) {
            cs[i] ^= cs[j];
            cs[j] ^= cs[i];
            cs[i++] ^= cs[j--];
        }
    }
}

// StringBuilder 拼接
class Solution2 {
    public String reverseLeftWords(String s, int n) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < cs.length; i++) sb.append(cs[i]);
        for (int i = 0; i < n; i++) sb.append(cs[i]);
        return sb.toString();
    }
}