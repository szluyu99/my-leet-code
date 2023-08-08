// 完全背包模板代码
public class Solution {
    // 朴素版 
    // v - 价值数组, w - 重量数组, c - 背包容量
    static int maxValue0(int[] v, int[] w, int c) {
        int[][] dp = new int[v.length + 1][c + 1];
        for (int i = 1; i <= v.length; i++) // 物品
            for (int j = 1; j <= c; j++) // 背包
                for (int k = 0; k * w[i - 1] <= j; k++) // 物品数量
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1] * k] + v[i - 1] * k);
        return dp[w.length][c];
    }

    // 二维数组实现
    static int maxValue1(int[] v, int[] w, int c) {
        // dp[i][j] 有前 i 个物品可选, 最大承重为 j 的背包的物品总价值
        int[][] dp = new int[v.length + 1][c + 1];
        for (int i = 1; i <= v.length; i++) // 物品
            for (int j = 1; j <= c; j++) // 背包
                // 容量不够放本次的物品
                if (j < w[i - 1]) dp[i][j] = dp[i - 1][j];
                // 容量够放本次物品
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w[i - 1]] + v[i - 1]);
        return dp[v.length][c];
    }

    // 一维数组实现
    static int maxValue2(int[] v, int[] w, int c) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < v.length; i++)
            for (int j = w[i]; j <= c; j++)
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
        return dp[c];
    }

    public static void main(String[] args) {
        int[] values = { 6, 3, 5, 4, 6 }; // 价值
        int[] weights = { 2, 2, 6, 5, 4 }; // 重量
        int capacity = 10; // 背包容量
        System.out.println(maxValue0(values, weights, capacity)); // 朴素版
        System.out.println(maxValue1(values, weights, capacity)); // 二维数组
        System.out.println(maxValue2(values, weights, capacity)); // 一维数组
    }
}
