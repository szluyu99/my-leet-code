/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 动态规划
 */
class Solution {
    public int cuttingRope(int n) {
        // dp[i] 表示长度为 i 的绳子剪过程 m 段后长度的最大乘积(m>1)
        int[] dp = new int[n + 1];
        dp[2] = 1; // 初始化
        // 目标: 求 dp[n]
        for (int i = 3; i <= n; i++)
            // 首先对绳子剪长度为 j 的一段, j 范围是 2 <= j < i
            // 剪掉的长度为 1 的话, 对乘积没有任何增益, 所以从 2 开始剪
            for (int j = 2; j < i; j++) {
                // j * (i - j) 表示剪了长度 j 以后，剩下 (i-j) 不剪
                // j * dp[i - j] 表示剪了长度 j 以后, 剩下 (i-j) 继续剪, 从之前 dp 数组找最大值
                int nowBigger = Math.max(j * (i - j), j * dp[i - j]);
                // 对于同一个 i, 内层循环对不同的 j 拿到的 max 不同, 每次循环要更新 max
                dp[i] = Math.max(dp[i], nowBigger);
            }
        return dp[n];
    }
}