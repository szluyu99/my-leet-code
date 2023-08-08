package CodeTop;

// https://leetcode.cn/problems/max-area-of-island/
class Solution {
    int[][] grid;
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(i, j));
            }
        }

        return maxArea;
    }

    int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (grid[i][j] == 0 || grid[i][j] == -1) return 0;
        grid[i][j] = -1;
        int area = 1;
        area += dfs(i - 1, j);
        area += dfs(i, j - 1);
        area += dfs(i + 1, j);
        area += dfs(i, j + 1);
        return area;
    }
}