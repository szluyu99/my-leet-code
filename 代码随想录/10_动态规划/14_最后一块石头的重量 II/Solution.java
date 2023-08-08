import java.util.Arrays;

// https://leetcode.cn/problems/last-stone-weight-ii/
class Solution {
    public int lastStoneWeightII(int[] stones) {
        // 核心思路：任意选 i 块石头，使它们的重量趋近于总重量的一半，因为这样和另一半抵消的差值就是最小的
        // 背包容量为和的一半, 试图寻找尽量装满一半的背包的元素的和
        // 最极端就是正好找到一半, 剩下的元素构成另一半, 得出结果为 0
        int sum = Arrays.stream(stones).sum();
        int max = maxValue(stones, stones, sum / 2);
        return Math.abs(max - (sum - max));
    }

    // 二维01背包
    int maxValue(int[] w, int[] v, int c) {
        int[][] dp = new int[w.length + 1][c + 1];
        for (int i = 1; i <= w.length; i++) 
            for (int j = 1; j <= c; j++)
                if (j < w[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
        return dp[w.length][c];
    }

    // 一维01背包
    int maxValue2(int[] w, int[] v, int c) {
        int[] dp = new int[c + 1];
        for (int i = 1; i <= w.length; i++)
            for (int j = c; j >= w[i - 1]; j--)
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
        return dp[c];
    }
}