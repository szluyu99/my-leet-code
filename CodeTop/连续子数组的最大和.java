package CodeTop;

// https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
// DP
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i] 表示以 i 为结尾的子数组的最大和
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// 贪心
class Solution1 {
    public int maxSubArray(int[] nums) {
        int tmpSum = 0, result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (tmpSum < 0) tmpSum = nums[i];
            else tmpSum += nums[i];
            result = Math.max(result, tmpSum);
        }
        return result;
    }
}