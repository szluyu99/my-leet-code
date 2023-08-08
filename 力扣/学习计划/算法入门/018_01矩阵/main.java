/**
 * DFS
 */
class Solution {
    private int min;

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                min = Integer.MAX_VALUE;
                dfs(mat, i, j, 0, visited);
                mat[i][j] = min;
            }
        }
        return mat;
    }

    void dfs(int[][] mat, int i, int j, int dis, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j])
            return;
        // 剪枝
        if (dis > min) return;
        if (mat[i][j] == 0) {
            min = Math.min(min, dis);
            return;
        }
        // 标记已访问
        visited[i][j] = true;
        dfs(mat, i - 1, j, dis + 1, visited);
        dfs(mat, i, j + 1, dis + 1, visited);
        dfs(mat, i + 1, j, dis + 1, visited);
        dfs(mat, i, j - 1, dis + 1, visited);
        // 回溯
        visited[i][j] = false;
    }
}