// https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[] {};
        final int INF = 0x3f3f3f3f;
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        res[0] = matrix[0][0]; // 第一个元素手动处理
        matrix[0][0] = INF;
        int x = 0, y = 0, k = 1; // k 从第二个元素开始放
        while (k < m * n) {
            while (y < n - 1 && matrix[x][y + 1] != INF) {
                res[k++] = matrix[x][++y];
                matrix[x][y] = INF;
            }
            while (x < m - 1 && matrix[x + 1][y] != INF) {
                res[k++] = matrix[++x][y];
                matrix[x][y] = INF;
            }
            while (y > 0 && matrix[x][y - 1] != INF) {
                res[k++] = matrix[x][--y];
                matrix[x][y] = INF;
            }
            while (x > 0 && matrix[x - 1][y] != INF) {
                res[k++] = matrix[--x][y];
                matrix[x][y] = INF;
            }
        }
        return res;
    }
}