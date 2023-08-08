package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> res = new ArrayList<>();

        int m = a.length, n = a[0].length;
        boolean[][] v = new boolean[m][n];

        int x = 0, y = 0, k = m * n;
        v[0][0] = true;
        res.add(a[0][0]);
        while (k-- > 1) {
            while (y < n - 1 && !v[x][y + 1]) { // 右
                res.add(a[x][++y]);
                v[x][y] = true;
            }
            while (x < m - 1 && !v[x + 1][y]) { // 下
                res.add(a[++x][y]);
                v[x][y] = true;
            }
            while (y > 0 && !v[x][y - 1]) { // 左
                res.add(a[x][--y]);
                v[x][y] = true;
            }
            while (x > 0 && !v[x - 1][y]) { // 上
                res.add(a[--x][y]);
                v[x][y] = true;
            }
        }
        return res;
    }
}