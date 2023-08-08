/**
 * 01背包模板代码
 */
class Solution {
    // 二维数组实现
    // v - 价值数组, w - 重量数组, c - 背包容量
    static int maxValue(int[] v, int[] w, int c) {
        // dp[i][j] 有前 i 个物品可选, 最大承重为 j 的背包的物品总价值
        int[][] dp = new int[v.length + 1][c + 1];
        for (int i = 1; i <= v.length; i++) // 物品
            for (int j = 1; j <= c; j++) // 背包
                // 容量不够放本次的物品
                if (j < w[i - 1]) dp[i][j] = dp[i - 1][j];
                // 容量够放本次物品: 比较 放 与 不放 获得的最大总价值来选择
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
        return dp[v.length][c];
    }

    // 一维数组实现
    static int maxValue1(int[] v, int[] w, int c) {
        int[] dp = new int[c + 1];
        for (int i = 1; i <= v.length; i++) // 物品
            for (int j = c; j >= w[i - 1]; j--) // 背包
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
        return dp[c];
    }

    public static void main(String[] args) {
        int[] values = { 6, 3, 5, 4, 6 }; // 价值
        int[] weights = { 2, 2, 6, 5, 4 }; // 重量
        int capacity = 10; // 背包容量
        System.out.println(maxValue(values, weights, capacity));
        System.out.println(maxValue1(values, weights, capacity));
    }
}
