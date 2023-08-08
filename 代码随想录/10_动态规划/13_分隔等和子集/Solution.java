import java.util.Arrays;

// https://leetcode.cn/problems/partition-equal-subset-sum/
class Solution {
public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    // 奇数, 必定无法分隔
    if ((sum & 1) == 1) return false;
    // 目标子集的元素和
    int target = sum / 2;
    // 转化成 01背包问题
    // dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
    return maxValue1(nums, nums, target) == target; 
}

    // 二维01背包模板
    int maxValue(int[] v, int[] w, int c) {
        // dp[i][j] 在前 i 个物品中选择, 容量为 j 的最大物品价值
        int[][] dp = new int[v.length + 1][c + 1];
        for (int i = 1; i <= v.length; i++)
            for (int j = 1; j <= c; j++)
                if (j < w[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
        return dp[v.length][c];
    }

    // 一维01背包模板
    int maxValue1(int[] v, int[] w, int c) {
        int[] dp = new int[c + 1];
        for (int i = 1; i <= v.length; i++)
            for (int j = c; j >= w[i - 1] ; j--)
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
        return dp[c];
    }
}