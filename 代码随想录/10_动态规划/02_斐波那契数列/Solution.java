// https://leetcode.cn/problems/fibonacci-number/
// 动态规划 
class Solution {
    public int climbStairs(int n) {
        // dp[i] - 达到 i 阶楼梯的方法数
        int[] dp = new int[n + 1];
        // 初始化 dp 数组
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// 滚动数组优化
class Solution1 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}