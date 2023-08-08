/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
class Solution {
    /**
     * 动态规划1
     */
    public int maxSubArray(int[] nums) {
        // dp[i]的含义：以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) 
                dp[i] = dp[i-1] + nums[i];
            else 
                dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /**
     * 动态规划2
     */
    public int maxSubArray2(int[] nums) {
        // dp[i]的含义: 以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}