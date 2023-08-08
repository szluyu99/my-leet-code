class Solution {
    /**
     * 十分原始的动态规划（原地修改，降低空间复杂度）
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 优化初始情况
     */
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++)
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }

    /**
     * 多开一行一列的空间，简化代码
     */
    public int maxValue3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
        return dp[m][n];
    }

}