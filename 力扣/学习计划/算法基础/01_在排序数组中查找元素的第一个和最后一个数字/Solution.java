// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { - 1, -1 };
        // 二分找左边界
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[] { -1, -1 };
        int leftBound = l; // 找到左边界
        // 二分找右边界
        l = 0; r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        int rightBound = l; // 找到右边界
        return new int[] { leftBound, rightBound };
    }
}