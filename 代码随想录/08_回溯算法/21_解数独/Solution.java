// https://leetcode.cn/problems/sudoku-solver/
class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                // 尝试 1~9 的数字
                for (char n = '1'; n <= '9'; n++) {
                    if (check(board, i, j, n)) {
                        board[i][j] = n; // 填入数字
                        // 找到解直接返回
                        if (dfs(board)) return true;
                        board[i][j] = '.'; // 回溯
                    }
                }
                return false; // 9 个数字都试完了
            }
        }
        return true; // 正常遍历完就是找到解
    }

    // 在 board[x][y] 位置放置 k 是否合法
    boolean check(char[][] board, int x, int y, int k) {
        // 检查 当前列 和 当前行 是否合法
        for (int i = 0; i < 9; i++) 
            if (board[i][y] == k || board[x][i] == k)
                return false;
        // 检查当前 3x3 宫内是否合法，定位到 3x3 宫位置
        // (xx, yy) 3x3 宫左上角, (xx + 2, yy + 2) 3x3 宫右下角
        int xx = x / 3 * 3, yy = y / 3 * 3;
        for (int i = xx; i <= xx + 2; i++) 
            for (int j = yy; j <= yy + 2; j++) 
                if (board[i][j] == k) return false;
        return true;
    }
}