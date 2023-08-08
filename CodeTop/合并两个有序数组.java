package CodeTop;

// https://leetcode.cn/problems/merge-sorted-array/
// 从后往前遍历, 取最大值放入
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--]; 
            } else {
                nums1[k--] = nums1[i--]; 
            }
        }
    }
}