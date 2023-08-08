// https://leetcode.cn/problems/unique-paths-ii/
class Solution {
public int uniquePathsWithObstacles(int[][] g) {
    int m = g.length, n = g[0].length;
    // dp[i][j] 到达 [i][j] 的不同路径数
    int[][] dp = new int[m][n];
    dp[0][0] = 0;

    for (int i = 0; i < m; i++) {
        if (g[i][0] == 1) break;
        dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
        if (g[0][i] == 1) break;
        dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (g[i][j] == 1) continue;
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
}