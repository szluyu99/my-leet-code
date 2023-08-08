// https://leetcode.cn/problems/maximum-subarray/
// 动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] 以 i 结尾的最大连续子数组和
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }    
        return max;
    }
}

// 贪心
class Solution1 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = 0; // 保存临时值
        for (int num : nums) {
            tmp += num;
            if (tmp > max) max = tmp;
            if (tmp < 0) tmp = 0;
        }
        return max;
    }
}