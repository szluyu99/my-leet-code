import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int INF = 0x3f3f3f3f; // 无穷大标记为已访问
        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        matrix[0][0] = INF;
        int m = matrix.length, n = matrix[0].length;
        int k = m * n;
        int x = 0, y = 0;
        while (k-- > 1) {
            while (y < n - 1 && matrix[x][y + 1] != INF) { // 右
                res.add(matrix[x][++y]);
                matrix[x][y] = INF;
            }
            while (x < m - 1 && matrix[x + 1][y] != INF) { // 下
                res.add(matrix[++x][y]);
                matrix[x][y] = INF;
            }
            while (y > 0 && matrix[x][y - 1] != INF) { // 左
                res.add(matrix[x][--y]);
                matrix[x][y] = INF;
            }
            while (x > 0 && matrix[x - 1][y] != INF) { // 上
                res.add(matrix[--x][y]);
                matrix[x][y] = INF;
            }
        }
        return res;
    }
}