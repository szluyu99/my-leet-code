/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
class Solution {
    /**
     * 递归（超时）
     */
    public int maxValue(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];
        return helper(grid, grid.length - 1, grid[0].length - 1);
    }

    int helper(int[][] grid, int x, int y) {
        if (x < 0 || y < 0)
            return 0;
        if (x == 0) {
            int res = 0;
            for (int i = 0; i <= y; i++)
                res += grid[0][i];
            return res;
        }
        if (y == 0) {
            int res = 0;
            for (int i = 0; i <= x; i++)
                res += grid[i][0];
            return res;
        }
        return Math.max(helper(grid, x - 1, y), helper(grid, x, y - 1)) + grid[x][y];
    }
}