package CodeTop._数组;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/
// 双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l - 1]) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}

// 交换次数太多
class Solution1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 1, r = 1;
        while (r < n) {
            if (nums[l] <= nums[l - 1]) {
                while (r < n && nums[r] <= nums[l - 1]) r++;
                if (r == n) break;
                swap(nums, l, r);
                l++;
            } else {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
        return l;
    }

    void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}