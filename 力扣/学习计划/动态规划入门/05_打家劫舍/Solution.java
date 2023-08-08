// https://leetcode-cn.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] 偷第 i 号房屋时的最高金额
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) 
            // 今天偷 或 不偷 两种选择
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        return dp[n];
    }
}