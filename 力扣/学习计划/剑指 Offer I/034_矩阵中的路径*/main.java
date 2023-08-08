/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 */
class Solution {
    /**
     * DFS + 剪枝
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, words, i, j, 0))
                    return true;
        return false;
    }

    /**
     * 深度优先搜索
     * 
     * @param words  搜索目标
     * @param board 搜索范围
     * @param i     当前元素的行索引
     * @param j     当前元素的列索引
     * @param k     搜索目标在wrod中的索引
     * @return
     */
    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 边界情况判断：行越界、列越界、矩阵元素已经访问过 
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || board[i][j] != words[k])
            return false;
        // 全部搜索完毕，返回true
        if (k == words.length - 1)
            return true;
        // 剪枝，将当前节点赋值 '#', 防止下次递归往回查找
        board[i][j] = '#';
        boolean res = dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i, j - 1, k + 1);
        // 回溯，恢复原来的字符
        board[i][j] = words[k];
        return res;
    }
}