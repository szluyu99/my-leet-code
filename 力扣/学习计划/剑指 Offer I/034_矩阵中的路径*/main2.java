class Solution {
    /**
     * DFS + 剪枝
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, words, visited, i, j, 0))
                    return true;
        return false;
    }

    /**
     * 深度优先搜索
     * 
     * @param words   搜索目标
     * @param board   搜索范围
     * @param visited 已经搜索过的路径
     * @param i       当前元素的行索引
     * @param j       当前元素的列索引
     * @param k       搜索目标在wrod中的索引
     * @return
     */
    boolean dfs(char[][] board, char[] words, boolean[][] visited, int i, int j, int k) {
        // 边界情况判断：行越界、列越界、矩阵元素已经访问过
        if (i >= board.length || i < 0 // 行越界
                || j >= board[0].length || j < 0 // 列越界
                || board[i][j] != words[k] // 当前元素不是想要搜索的元素
                || visited[i][j]) // 矩阵元素已经访问过
            return false;
        // 全部搜索完毕，返回true
        if (k == words.length - 1)
            return true;
        // 剪枝, 防止下次递归往回查找
        visited[i][j] = true;
        boolean res = dfs(board, words, visited, i + 1, j, k + 1)
                || dfs(board, words, visited, i - 1, j, k + 1)
                || dfs(board, words, visited, i, j + 1, k + 1)
                || dfs(board, words, visited, i, j - 1, k + 1);
        // 回溯，恢复
        visited[i][j] = false;
        return res;
    }
}