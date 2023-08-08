/**
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 944. 删列造序
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int sum = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}
