/**
 * https://leetcode-cn.com/problems/rotate-string/
 * 旋转字符串
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return s.repeat(2).contains(goal);
    }
}