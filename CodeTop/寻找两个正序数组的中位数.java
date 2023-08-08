package CodeTop;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n == 0) return compute(nums2);
        if (m == 0) return compute(nums1);

        int[] nums = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            nums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < n) nums[k++] = nums1[i++];
        while (j < m) nums[k++] = nums2[j++];

        return compute(nums);
    }

    double compute(int [] nums) {
        int n = nums.length;
        if (n % 2 == 1) return nums[n / 2];
        else {
            int a = nums[n / 2], b = nums[n / 2 - 1];
            return (a + b) / 2.0;
        }
    }
}