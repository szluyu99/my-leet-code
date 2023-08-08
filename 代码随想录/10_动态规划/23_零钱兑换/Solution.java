import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/submissions/

// 递归
class Solution {
    int minCount = Integer.MAX_VALUE;
    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        if (coins.length == 0) return -1;

        dfs(amount, 0);

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    void dfs(int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) minCount = Math.min(minCount, count);

        for (int i = 0; i < coins.length; i++) {
            dfs(amount - coins[i], count + 1);
        }
    }
}

// dp
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 凑到总金额为 i 需要的最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int i = 0; i < coins.length; i++) // 物品
            for (int j = coins[i]; j <= amount; j++) 
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}