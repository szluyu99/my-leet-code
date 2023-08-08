// https://leetcode.cn/problems/spiral-matrix-ii/
// 模拟
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0, y = 0, k = 2;
        res[0][0] = 1; // 第一个位置要手动放
        while (k <= n * n) {
            while (y < n - 1 && res[x][y + 1] == 0) res[x][++y] = k++; // 右
            while (x < n - 1 && res[x + 1][y] == 0) res[++x][y] = k++; // 下
            while (y > 0 && res[x][y - 1] == 0) res[x][--y] = k++; // 左
            while (x > 0 && res[x - 1][y] == 0) res[--x][y] = k++; // 上
        }
        return res;
    }
}