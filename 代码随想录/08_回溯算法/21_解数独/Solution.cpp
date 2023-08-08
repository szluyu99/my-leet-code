#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        dfs(board);
    }

    bool dfs(vector<vector<char>>& board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') continue;
                for (char n = '1'; n <= '9'; n++) {
                    if (check(board, x, y, n)) {
                        board[x][y] = n;
                        if (dfs(board)) return true;;
                        board[x][y] = '.'; // 回溯
                    }
                }
                return false;
            }
        }
        return true;
    }

    // 在 board[x][y] 放置 k 是否合法
    bool check(vector<vector<char>>& board, int x, int y, int k) {
        // 检查 (x, y) 所在行列是否合法
        for (int i = 0; i < 9; i++) 
            if (board[x][i] == k || board[i][y] == k) return false; 
        // 检查 (x, y) 所在 3x3 宫格是否合法
        int xx = x / 3 * 3, yy = y / 3 * 3;
        for (int i = xx; i <= xx + 2; i++)
            for (int j = yy; j <= yy + 2; j++)
                if (board[i][j] == k) return false;
        return true;
    }
};