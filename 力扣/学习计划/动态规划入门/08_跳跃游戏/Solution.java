// https://leetcode-cn.com/problems/jump-game/comments/
// 贪心
class Solution {
public boolean canJump(int[] nums) {
    int cover = 0; // 能跳到的最远位置
    for (int i = 0; i <= cover; i++) {
        cover = Math.max(cover, i + nums[i]);
        if (cover >= nums.length - 1) return true;
    }
    return false;
}
}

// DP
class Solution1 {
    public boolean canJump(int[] nums) {
        // 只有一个下标, 一定可以到达
        if (nums.length == 1) return true;
        // 不止一个下标, 且第一步为0, 一定不能到达
        if (nums[0] == 0) return false;

        // dp[i] 能否到达坐标 i
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true; // 坐标0一定能到
        for (int i = 0; i < nums.length; i++) {
            // 如果能到达当前下标, 才能继续跳
            if (!dp[i]) continue;
            // 计算当前能跳到的位置 
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = true;
            }
        }
        return dp[nums.length - 1];
    }
}