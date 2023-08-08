package CodeTop.最大子数组和;

// https://leetcode.cn/problems/maximum-subarray/
// 动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // dp[i] - 以 i 结尾的最大子数组和
        int[] dp = new int[n];
        dp[0] = nums[0]; 

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) dp[i] = nums[i];
            else dp[i] = dp[i - 1] + nums[i];
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }
}