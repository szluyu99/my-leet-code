import java.util.Arrays;

// https://leetcode.cn/problems/jump-game-ii/
// 动态规划
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] 跳到 i 位置使用的最少跳跃次数
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] + j >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
        return dp[n - 1];
    }
}

// 贪心
class Solution1 {
    public int jump(int[] nums) {
        int res = 0;
        int curDis = 0; // 当前的跳跃次数下最远能达到的距离
        int maxDist = nums[0]; // 当前的跳跃次数下再加一次最远能达到的距离
        for (int i = 1; i < nums.length; i++) {
            // 能在当前跳跃次数下到达就不会多跳
            if (i > curDis) { // 无法在当前跳跃次数下到达
                res++;
                curDis = maxDist;
            }
            // 更新当前次数下再跳一次能到达的最远距离
            maxDist = Math.max(maxDist, i + nums[i]);
        }
        return res;
    }
}