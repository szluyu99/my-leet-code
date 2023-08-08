/**
 * 归并排序
 */
class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 对 left, right 范围的数据进行归并排序
     */
    void sort(int[] nums, int left, int right) {
        // 至少需要两个元素
        if (right - left < 2) return;
        int mid = left + (right - left) >> 1;

        sort(nums, left, mid); // 归并排序左半子序列
        sort(nums, mid, right); // 归并排序右半子序列
        merge(nums, left, mid, right);
    }

    /**
     * 将 left,mid 和 mid, right 序列合并为有序序列
     */
    void merge(int[] nums, int left, int mid, int right) {
        int li = 0, le = mid - left; // 左边数组
        int ri = mid, re = right; // 右边数组
        int ai = left; // array 的索引

        
    }
}