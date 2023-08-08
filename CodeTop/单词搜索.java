package CodeTop;

// https://leetcode.cn/problems/word-search/
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, new boolean[m][n], i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] g, String s, boolean[][] visited, int i, int j, int k) {
        int m = g.length, n = g[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || s.charAt(k) != g[i][j]) {
            return false;
        }
        if (k == s.length() - 1) return true;
        visited[i][j] = true;
        boolean result = dfs(g, s, visited, i - 1, j, k + 1)
            || dfs(g, s, visited, i + 1, j, k + 1)
            || dfs(g, s, visited, i, j - 1, k + 1)
            || dfs(g, s, visited, i, j + 1, k + 1);
        visited[i][j] = false;
        return result;
    }
}