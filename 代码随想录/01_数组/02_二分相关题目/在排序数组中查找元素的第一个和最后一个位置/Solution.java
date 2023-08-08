// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
// 二分找到值后, 分别往两边搜索边界
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { -1, -1 };
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[] { -1, -1 };
        while (l >= 0 && nums[l] == target) l--; // 找左边界
        while (r < nums.length && nums[r] == target) r++; // 找右边界
        return new int[] { l + 1, r - 1 };
    }
}

// 二分找左边界 + 二分找右边界
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { -1, -1 };
        // 二分找左边界
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[] { -1, -1 };
        int lb = l;
        // 二分找右边界
        l = 0; r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        int rb = l;
        return new int[] { lb, rb };
    }
}