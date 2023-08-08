// https://leetcode.cn/problems/remove-element/
// 双指针
class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int r = 0; r < nums.length; r++)
            if (nums[r] != val) nums[l++] = nums[r];
        return l;
    }
}