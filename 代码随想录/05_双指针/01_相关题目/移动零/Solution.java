// https://leetcode.cn/problems/move-zeroes/
// 快慢指针
class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++)
            if (nums[r] != 0) swap(nums, r, l++);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
// 双指针
class Solution1 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        // 将非 0 元素按顺序放到前面
        for (int r = 0; r < nums.length; r++)
            if (nums[r] != 0) nums[l++] = nums[r];
        // 后面全部赋 0
        while (l < nums.length) nums[l++] = 0;
    }
}