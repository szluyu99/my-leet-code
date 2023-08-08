package CodeTop._前缀和;

// https://leetcode.cn/problems/running-sum-of-1d-array/submissions/
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }
}
