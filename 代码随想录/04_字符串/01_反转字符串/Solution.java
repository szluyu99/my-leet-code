// https://leetcode.cn/problems/reverse-string/
// 迭代
class Solution {
    public void reverseString(char[] s) {
        int size = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            int j = size - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}