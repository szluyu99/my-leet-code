import javax.management.MBeanTrustPermission;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * 旋转矩阵
 */
class Solution {
    /**
     * 模拟
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 00 -> 02
                // 01 -> 12
                int temp = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                // 02 -> 22
                // 12 -> 21
                int temp2 = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = temp;
                // 22 -> 20
                // 21 -> 10
                temp = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = temp2;
                // 20 -> 00
                // 10 -> 01
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 模拟（优化代码）
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = i; j < n - i; j++) {
                // 获取各顶点的值
                int a = matrix[i][j]; // 左上角
                int b = matrix[j][n - i]; // 右上角
                int c = matrix[n - i][n - j]; // 右下角
                int d = matrix[n - j][i]; // 左下角
                // 交换各顶点的值
                matrix[i][j] = d;
                matrix[j][n - i] = a;
                matrix[n - i][n - j] = b;
                matrix[n - j][i] = c;
            }
        }
    }
}
// 00 -> 02 -> 22 -> 20 -> 00
// 01 -> 12 -> 21 -> 10 -> 01
// 02 -> 22 -> 20 -> 00 -> 02
