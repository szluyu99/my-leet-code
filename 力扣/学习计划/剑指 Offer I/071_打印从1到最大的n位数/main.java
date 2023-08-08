/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 打印从1到最大的n位数
 */
class Solution {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10.0, n);
        int[] res = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}