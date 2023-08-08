/**
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * 写字符串需要的行数
 */
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        res[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            res[1] += widths[s.charAt(i) - 'a'];
            if (res[1] > 100) {
                res[0]++;
                res[1] = widths[s.charAt(i) - 'a'];
            }
        }
        return res;
    }
}