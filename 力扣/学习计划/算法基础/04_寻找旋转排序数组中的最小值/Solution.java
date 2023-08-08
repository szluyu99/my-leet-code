// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    // 左边界找最小值, 最小值一定在无序那半边
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            // nums[mid] < nums[r] 表示 [mid, r] 是有序的, 则去左边一段找
            if (nums[mid] < nums[r]) r = mid;
            // nums[mid] >= nums[r] 表示 [mid, r] 不是有序的, 就在这段中继续找
            else l = mid + 1;
        }
        return nums[l];
    }
}