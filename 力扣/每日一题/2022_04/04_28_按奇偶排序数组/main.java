/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 按奇偶排序数组
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] & 1 == 0) swap(nums, l++, r);
        }
        return nums;
    }

    void swap(int[] nums, int n1, int n2) {
        int t = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = t;
    }
}