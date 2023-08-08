package CodeTop;

// https://leetcode.cn/problems/minimum-path-sum/

// DP
class Solution {
    public int minPathSum(int[][] grid) {
        int m  = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];        
    }
}

// dfs 超时
class Solution1 {
    int[][] grid;
    int minSum = Integer.MAX_VALUE;
    int m, n;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        dfs(0, 0, 0);
        return minSum;
    }

    void dfs(int i, int j, int sum) {
        if (i >= m || j >= n || grid[i][j] == -1) {
            return;
        }

        if (i == m - 1 && j == n - 1) {
            if (sum + grid[i][j] < minSum) {
                minSum = sum + grid[i][j];
                return;
            }
        }
        
        int tmp = grid[i][j];
        grid[i][j] = -1;
        dfs(i, j + 1, sum + tmp); // right
        dfs(i + 1, j, sum + tmp); // down
        grid[i][j] = tmp;
    }
}