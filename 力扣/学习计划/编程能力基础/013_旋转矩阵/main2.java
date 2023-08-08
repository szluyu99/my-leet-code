import java.util.regex.MatchResult;

class Solution {
    /**
     * 技巧
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再沿垂直竖线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}