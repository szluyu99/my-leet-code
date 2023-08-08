/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 暴力
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[] {};
        // 滑动窗口边界
        int left = 0, right = k - 1;
        int[] res = new int[nums.length - k + 1];

        // 开始滑动
        int idx = 0, max = nums[0];
        while (right < nums.length) {
            max = nums[left];
            // 每次滑动获取最大值
            for (int i = left; i <= right; i++)
                max = Math.max(max, nums[i]);
            res[idx++] = max;
            left++;
            right++;
        }

        return res;
    }
}