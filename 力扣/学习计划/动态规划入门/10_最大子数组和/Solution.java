//https://leetcode-cn.com/problems/maximum-subarray/
class Solution {
    // 标准 DP
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 优化 DP: 由于 dp 数组只用到了 dp[i - 1], 用一个变量优化掉
    public int maxSubArray1(int[] nums) {
        int cur = nums[0], max = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
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