/**
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * 数字序列中某一位的数字
 */
class Solution {
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++)
            sb.append(i);
        return sb.charAt(n) - '0';
    }
}