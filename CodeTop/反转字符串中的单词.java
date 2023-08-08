package CodeTop;

import java.util.Stack;

// https://leetcode.cn/problems/reverse-words-in-a-string/
// split 
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            sb.append(ss[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

// 双指针
class Solution1 {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int i = n - 1, j = n - 1;
        while (j >= 0) {
            while (j >= 0 && s.charAt(j) != ' ') j--;
            sb.append(s.substring(j + 1, i + 1));
            sb.append(" ");
            while (j >= 0 && s.charAt(j) == ' ') j--;
            i = j; 
        }

        return sb.toString().trim();
    }
}