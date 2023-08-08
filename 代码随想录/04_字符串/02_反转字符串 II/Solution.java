// https://leetcode.cn/problems/reverse-string-ii/  
class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i += (k * 2)) {
            // 如果剩余字符少于 k 个，则将剩余字符全部反转
            if (len - i < k) reverse(cs, i, len - 1);
            // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
            // else if (len - i < k * 2) reverse(cs, i, i + k - 1); // 可省略
            // 每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
            else reverse(cs, i, i + k - 1); 
        }
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