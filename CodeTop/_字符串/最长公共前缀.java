package CodeTop._字符串;

// https://leetcode.cn/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 数组中最短的那个字符串的长度
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }

        // 每个字符串横向扫描一遍, 都拥有该字符才添加到前缀中
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < minLen) {
            char c = strs[0].charAt(idx);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(idx) != c)
                    return sb.toString();
            }
            sb.append(c);
            idx++;
        }
        return sb.toString();
    }
}

// 选一个字符串，每轮查看是否所有字符串都以它为开始，不满足则截到倒数第二位
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}