package CodeTop;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            // 相邻
            if (r - l == 1) break; 
            int mid = l + r >> 1;
            // 中间值大于两端，则说明最小值在右侧
            if (nums[mid] < nums[l] && nums[mid] < nums[r]) r = mid;
            // 中间值小于两端，则说明最小值在左侧
            else if (nums[mid] > nums[l] && nums[mid] > nums[r]) l = mid + 1;
            // 中间值介于两者之间，则说明此时已按顺序排列，最小值就是 l
            else if (nums[l] < nums[mid] && nums[mid] < nums[r]) break;
        }
        return Math.min(nums[l], nums[r]);
    }
}