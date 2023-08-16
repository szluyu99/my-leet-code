package CodeTop._数组;

// https://leetcode.cn/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) swap(nums, i, l++);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 2) swap(nums, i, r--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}