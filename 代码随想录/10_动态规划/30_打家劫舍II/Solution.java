import java.util.Arrays;

// https://leetcode.cn/problems/house-robber-ii/
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
                help(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                help(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int help(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        return dp[n];
    }
}