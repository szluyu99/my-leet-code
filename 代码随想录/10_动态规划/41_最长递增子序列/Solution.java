import java.util.Arrays;

// https://leetcode.cn/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以 i 结尾的最长递增子序列的个数
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 每个位置的上升子序列至少是 1
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) 
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}