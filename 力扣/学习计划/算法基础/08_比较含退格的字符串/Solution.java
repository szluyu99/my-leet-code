// https://leetcode.cn/problems/backspace-string-compare
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }

    String convert(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0; // '#' 的数量
        char[] cs = s.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') cnt++;
            else if (cnt > 0) cnt--;
            else sb.append(cs[i]);
        } 
        System.out.println(sb.toString());
        return sb.toString();
    }
}