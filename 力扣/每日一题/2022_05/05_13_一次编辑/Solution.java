/**
 * https://leetcode.cn/problems/one-away-lcci/
 * 一次编辑
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length(), l2 = second.length();
        if (Math.abs(l1 - l2) > 1)
            return false;
        if (l1 > l2)
            return oneEditAway(second, first);

        int i = 0, j = 0, cnt = 0;
        while (i < l1 && j < l2 && cnt <= 1) {
            char c1 = first.charAt(i), c2 = second.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                if (l1 == l2)
                    i++;
                j++;
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
