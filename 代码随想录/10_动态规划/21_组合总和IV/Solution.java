// https://leetcode.cn/problems/combination-sum-iv/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] 总和为 i 的元素排列个数
        int[] dp = new int[target + 1]; 
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int j = 1; j <= nums.length; j++) {
                // 选这个数: dp[i - nums[j]]
                // 不选这个数: dp[i]
                dp[i] = dp[i] + dp[i - nums[j]];
            }
        return dp[target];
    }
}

class Solution1 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i][j] 在前 i 个元素中总和为 j 的排列个数
        int[][] dp = new int[nums.length + 1][target + 1];
        // 总和为 0, 一个数也不选, 视为一种情况
        for (int i = 0; i <= nums.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= nums.length; i++) // 物品
            for (int j = 1; j <= target; j++) // 背包
                for (int k = i; k > 0; k--)
                    if (j - nums[k - 1] >= 0)
                        dp[i][j] += dp[i][j - nums[k - 1]];
        return dp[nums.length][target];
    }
}