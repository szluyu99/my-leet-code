/**
 * https://leetcode-cn.com/problems/monotonic-array/
 * 896. 单调数列
 */


class Solution {
    /**
     * 遍历数组一次，如果遇到 nums[i] > nums[i+1] 和 nums[i] < nums[i+1]
     * 说明 nums 既不单调增也不单调减
     */
    public boolean isMonotonic(int[] nums) {
        boolean inc = true, dec = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) inc = false;
            if (nums[i] < nums[i + 1]) dec = false;
            // 剪枝操作, 已经明确既不递增也不递减, 直接返回 false
            if (!inc && !dec) return false;
        }
        return inc || dec;
    }
    /**
     * 通过 nums[0] 和 nums[nums.length - 1] 判断出增减方向
     * 遍历数组一次，两两比较
     */
    public boolean isMonotonic1(int[] nums) {
        // 先判断 递增 还是 递减
        if (nums[0] <= nums[nums.length - 1]) { // 递增
            for (int i = 1; i < nums.length; i++) 
                if (nums[i - 1] > nums[i]) return false;
        } else { // 递减
            for (int i = 1; i < nums.length; i++) 
                if (nums[i - 1] < nums[i]) return false;
        }
        return true;
    }
}