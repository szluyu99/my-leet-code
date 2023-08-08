/**
 * 题解 - 模拟
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // 左右上下 边界
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        int idx = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];

        while (true) {
            // 左 -> 右
            for (int i = left; i <= right; i++)
                res[idx++] = matrix[top][i];
            // 左 -> 右 走完后, 收缩上边界, 同时判断能否往下走
            if (++top > bottom) break;
            // 上 -> 下
            for (int i = top; i <= bottom; i++) 
                res[idx++] = matrix[i][right];
            if (--right < left) break;
            // 右 -> 左
            for (int i = right; i >= left; i--)
                res[idx++] = matrix[bottom][i];
            if (--bottom < top) break;
            // 下 -> 上
            for (int i = bottom; i >= top; i--)
                res[idx++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}