/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/comments/
 * 区域和检索 - 数组不可变
 * 模拟
 */
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++)
            sum += nums[i];
        return sum;
    }
}