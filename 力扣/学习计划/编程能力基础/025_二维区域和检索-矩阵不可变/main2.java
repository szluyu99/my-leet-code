class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = (n == 0) ? 0 : matrix[0].length;
        sum = new int[n + 1][m + 1];
        // 预处理前缀和数组(模板)
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        x1++;
        y1++;
        x2++;
        y2++;
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }

}