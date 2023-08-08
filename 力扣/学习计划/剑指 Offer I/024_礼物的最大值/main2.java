class Solution {
    /**
     * 递归（存储中间结果优化）
     */
    public int maxValue(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        // 存储递归结果
        int[][] tmp = new int[grid.length][grid[0].length];
        return helper(grid, grid.length - 1, grid[0].length - 1, tmp);
    }

    int helper(int[][] grid, int x, int y, int[][]tmp) {
        // 取出存储的递归结果
        if (tmp[x][y] != 0)
            return tmp[x][y];
        if (x < 0 || y < 0)
            return 0;
        if (x == 0) {
            int res = 0;
            for (int i = 0; i <= y; i++)
                res += grid[0][i];
            tmp[x][y] = res; // 存储递归结果
            return res;
        }
        if (y == 0) {
            int res = 0;
            for (int i = 0; i <= x; i++)
                res += grid[i][0];
            tmp[x][y] = res; // 存储递归结果1
            return res;
        }
        // 存储递归结果
        tmp[x][y] = Math.max(helper(grid, x - 1, y, tmp), helper(grid, x, y - 1, tmp)) + grid[x][y];
        return tmp[x][y];
    }
}