/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 二维区域和检索 - 矩阵不可变
 */
/**
 * 暴力
 */
class NumMatrix {
    int[][] m;

    public NumMatrix(int[][] matrix) {
        m = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++)
            for (int j = col1; j <= col2; j++)
                sum += m[i][j];
        return sum;
    }
}
