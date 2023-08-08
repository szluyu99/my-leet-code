class NumMatrix {
    int[][] pre;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = (n == 0) ? 0 : matrix[0].length;
        pre = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            int tempSum = 0; // 每一行的前缀和数组
            for (int j = 0; j < m; j++) {
                tempSum += matrix[i][j];
                pre[i + 1][j + 1] = tempSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) 
            sum += pre[i + 1][col2 + 1] - pre[i + 1][col1];
        return sum;
    }
}