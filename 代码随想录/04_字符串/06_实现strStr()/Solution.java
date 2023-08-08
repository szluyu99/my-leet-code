// https://leetcode.cn/problems/implement-strstr/
// 双指针
class Solution {
    public int strStr(String s1, String s2) {
        if (s2 == "" || s1.equals(s2)) return 0;
        int l1 = s1.length(), l2 = s2.length();
        if (l1 < l2) return -1;

        char c1 = s2.charAt(0); // s2 的首字符
        for (int i = 0; i < l1 - l2 + 1; i++) {
            // 在 s1 中找 s2 的首字符
            if (s1.charAt(i) == c1) {
                // 开始逐位比较 s1 和 s2
                int j = 0;
                while (s1.charAt(i + j) == s2.charAt(j)) {
                    j++;
                    // 连续 l2 个长度的字符相同, 说明 s1 中包含 s2
                    if (j == l2) return i; 
                }
            }
        }
        return -1;
    }
}

// 滑动窗口
class Solution1 {
    public int strStr(String s1, String s2) {
        if (s2 == "" || s1.equals(s2)) return 0;
        int l1 = s1.length(), l2 = s2.length();
        if (l1 < l2) return -1;
        
        char c1 = s2.charAt(0); // s2 首字符
        for (int i = 0; i < l1 - l2 + 1; i++) 
            if (s1.charAt(i) == c1 && s2.equals(s1.substring(i, i + l2))) 
                return i;
        return -1;
    }
}

// API
class Solution2 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}