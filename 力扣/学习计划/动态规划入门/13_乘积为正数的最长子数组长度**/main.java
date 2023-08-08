// https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/
class Solution {
    public int getMaxLen(int[] nums) {
        // posDP[i] 以 nums[i] 结尾的正数的最长子数组的长度
        int[] posDP = new int[nums.length];
        posDP[0] = nums[0] > 0 ? 1 : 0; // 根据第一个数的正负初始化
        // negDP[i] 以 nums[i] 结尾的负数的最长子数组的长度
        int[] negDP = new int[nums.length];
        negDP[0] = nums[0] < 0 ? 1 : 0; // 根据第一个数的正负初始化

        int res = posDP[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) { // 当前数是 [正]
                // 如何更新当前正数的数量, 取决于上一个位置 正数 的数量
                posDP[i] = posDP[i - 1] + 1; // [正] * 正 = 正                
                // 如何更新当前负数的数量, 取决于上一个位置 负数 的数量
                negDP[i] = negDP[i - 1] > 0 ? negDP[i - 1] + 1 : 0; // [正] * 负 = 负
            } else if (nums[i] < 0) { // 当前数是 [负]
                // 如何更新当前正数的数量, 取决于上一个位置 负数 的数量
                posDP[i] = negDP[i - 1] > 0 ? negDP[i - 1] + 1 : 0; // [负] * 负 = 正
                // 如何更新当前负数的数量, 取决于上一个位置 正数 的数量
                negDP[i] = posDP[i - 1] + 1; // [负] * 正 = 负
            }
            res = Math.max(res, posDP[i]);
        }
        return res;
    }
}