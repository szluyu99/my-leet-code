package CodeTop._动态规划;

// https://leetcode.cn/problems/jump-game-ii/
// DP
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // dp[i] 表示跳到下标 i 的最小跳跃数
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (dp[i + j] == 0) {
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        return dp[n - 1];
    }
}

// 贪心
class Solution1 {
    public int jump(int[] nums) {
        int n = nums.length;
        int result = 0;

        int curMax = 0; // 当前跳跃次数下能达到的最远
        int nextMax = nums[0]; // 当前跳跃次数下再加一次最远能到的距离
        for (int i = 1; i < n; i++) {
            if (i > curMax) {
                result++;
                curMax = nextMax;
            }
            nextMax = Math.max(nextMax, nums[i] + i);
        }

        return result;
    }
}