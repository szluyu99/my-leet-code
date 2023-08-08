/**
 * https://leetcode-cn.com/problems/rotate-function/
 * 396. 旋转函数
 */
class Solution {
    // 暴力
    public int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = 1; j < nums.length; j++) {
                tmpSum += j * nums[(i + j) % nums.length];
            }
            max = Math.max(max, tmpSum);
        }
        return max;
    }
}