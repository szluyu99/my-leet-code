package CodeTop._二分;

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
// y总二分模板1 + 2
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[] { -1, -1 };

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target > nums[mid]) l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) return new int[]{ -1, -1 };

        int[] result = new int[2];
        result[0] = l;

        l = 0; 
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (target >= nums[mid]) l = mid;
            else r = mid - 1; 
        }
        if (nums[r] != target) return new int[] { -1, - 1};
        result[1] = r;
        return result;
    }
}