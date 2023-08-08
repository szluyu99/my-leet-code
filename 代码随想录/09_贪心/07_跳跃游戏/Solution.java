// https://leetcode.cn/problems/jump-game/
// DP
class Solution {
    public boolean canJump(int[] nums) {
        // dp[i] i 能跳到的最远下标
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < i) return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }
}

// 贪心: 每次取最大覆盖范围, 看是否能覆盖到终点
class Solution1 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}