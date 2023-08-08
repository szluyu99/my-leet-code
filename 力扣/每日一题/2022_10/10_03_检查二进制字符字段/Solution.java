// https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones
class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') cnt++;
            while (i < cs.length && cs[i] == '1') i++;
        }
        return cnt <= 1;
    }
}

class Solution1 {
    public boolean checkOnesSegment(String s) {
        return s.split("0").length == 1;
    }
}