package CodeTop;

class Solution {
    int m, n;
    char[][] g;

    public int numIslands(char[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1')  {
                    dfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || g[i][j] != '1') return;
        g[i][j] = '#';  
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
}