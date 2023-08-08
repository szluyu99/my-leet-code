// https://leetcode.cn/problems/backspace-string-compare/
// 从前往后重构字符串
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public String getString(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '#') sb.append(cs[i]);
            else if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
// 从后往前重构字符串
class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    private String getString(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int size = 0; // '#' 数量
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') size++; 
            else if (size == 0) sb.append(cs[i]); 
            else size--;
        }
        return sb.toString();
    }
}