package CodeTop.无重复字符的最长子串;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        int[] map = new int[200];
        while (r < s.length()) {
            char c = s.charAt(r);
            map[c]++;
            while (map[c] > 1) {
                map[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}