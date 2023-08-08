// https://leetcode.cn/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 到达 [i][j] 的不同路径数
        int[][] dp = new int[m + 1][n + 1];
        // 原点开始一直 往下 或 往右 走, 路径都是 1
        for (int i = 1; i <= m; i++) dp[i][1] = 1;
        for (int i = 1; i <= n; i++) dp[1][i] = 1;
        // 递推
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                // 当前路径总数 = 从左过来的路径 + 从上过来的路径
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}