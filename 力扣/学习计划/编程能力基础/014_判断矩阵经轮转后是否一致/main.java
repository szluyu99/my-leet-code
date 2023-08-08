class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // 不转
        if (checkMatrix(mat, target))
            return true;
        // 转 90 度
        rotate(mat);
        if (checkMatrix(mat, target))
            return true;
        // 转 180 度(再转 90 度)
        rotate(mat);
        if (checkMatrix(mat, target))
            return true;
        // 转 270 度(再转 90 度)
        rotate(mat);
        if (checkMatrix(mat, target))
            return true;
        return false;
    }

    /**
     * 将矩阵旋转 90 度
     */
    void rotate(int[][] matrix) {
        int n = matrix.length;
        // 沿 左上->右下 翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 沿 垂直中线 翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 检查两矩阵是否相等
     */
    boolean checkMatrix(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }
}