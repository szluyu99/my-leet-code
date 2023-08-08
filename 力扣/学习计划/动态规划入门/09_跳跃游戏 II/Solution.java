import java.util.Arrays;

// https://leetcode-cn.com/problems/jump-game-ii/
// DP
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // dp[i] 表示到达 i 位置到需要使用的最少跳跃次数
        int[] dp = new int[n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) return dp[n - 1];
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
}

// 贪心
class Solution1 {
    public int jump(int[] nums) {
        // curMax - 当前跳跃次数下的最远距离, nextMax 下一次跳跃能到的最远距离
        int res = 0, curMax = 0, nextMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > curMax) {
                res++;
                curMax = nextMax;
            }
            nextMax = Math.max(nextMax, i + nums[i]);
        }
        return res;
    }
}