// https://leetcode.cn/problems/coin-change-2/
class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] 组成金额 i 的硬币组合数
        // 选择硬币 coins[i], 当前硬币组合数量有 dp[j - coins[i]] 种
        // 不选择硬币 coins[i], 当前硬币组合数量为 dp[j] 种
        // 总的组合数量为: dp[j] = dp[j] + dp[j - coins[i]]
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 金额为 0 时, 什么都不装, 只有这一种方式
        for (int i = 0; i < coins.length; i++) // 物品
            for (int j = coins[i]; j <= amount; j++) // 背包
                dp[j] += dp[j - coins[i]];
        return dp[amount];
    }
}

class Solution1 {
    public int change(int amount, int[] coins) {
        // dp[i][j] 从前 i 个面额的硬币中选择, 凑出总金额为 j 的硬币的组合数
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化 dp 数组，金额为 0 时只有一种情况，也就是什么都不装
        for (int i = 0; i <= coins.length; i++) dp[i][0] = 1;
        for (int i = 1; i <= coins.length; i++) // 物品
            for (int j = 1; j <= amount; j++) { // 背包
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) dp[i][j] += dp[i][j - coins[i - 1]];
            }
        return dp[coins.length][amount];
    }
}