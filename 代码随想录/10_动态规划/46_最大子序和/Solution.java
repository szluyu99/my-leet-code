class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] 以 i 位置结尾的元素的连续子数组的最大和
        int[] dp = new int[nums.length];
        int res = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }   
}