class Solution {
    // 规律 + DP
    public int maxRotateFunction(int[] nums) {
        // f(n) = f(n - 1) + sum - len * nums[len - n]
        int[] dp = new int[nums.length];
        int len = nums.length;
        // 初始化DP数组, 同时求数组和
        int sum = 0;
        for (int i = 0; i < len; i++) {
            dp[0] += i * nums[i];
            sum += nums[i];
        };
        // 递推, 并求最大值
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + sum - len * nums[len - i];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}