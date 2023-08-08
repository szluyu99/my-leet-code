// https://leetcode.cn/problems/maximum-sum-of-an-hourglass/
class Solution {
    public int maxSum(int[][] g) {
        int n = g.length, m = g[0].length;
        int res = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res = Math.max(res, getSum(g, i, j));
        return res;
    }

    // 计算沙漏的和
    int getSum(int[][] g, int i, int j) {
        if (i + 2 >= g.length || j + 2 >= g[0].length) return -1;
        return g[i][j] + g[i][j + 1] + g[i][j + 2]
                + g[i + 1][j + 1]
                + g[i + 2][j] + g[i + 2][j + 1] + g[i + 2][j + 2];
    }
}