// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') sb.append(c);
            else sb.append("%20");
        }
        return sb.toString();
    }
}