package CodeTop.最长递增子序列;

// https://leetcode.cn/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i] 以 i 结尾的最长递增子序列的长度
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}