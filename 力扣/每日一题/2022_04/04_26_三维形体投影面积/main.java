/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * 三维形体投影面积
 */
class Solution {
    // 模拟
    public int projectionArea1(int[][] grid) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < grid.length; i++) {
            int tmpSum2 = 0;
            for (int j = 0; j < grid[0].length; j++) {
                // 底面和
                if (grid[i][j] != 0) sum1 += 1;
                // 正面和
                tmpSum2 = Math.max(tmpSum2, grid[i][j]);
            }
            sum2 += tmpSum2;
        }
        for (int j = 0; j < grid[0].length; j++) {
            int tmpSum3 = 0;
            for (int i = 0; i < grid.length; i++) {
                // 侧面和
                tmpSum3 = Math.max(tmpSum3, grid[i][j]);
            }
            sum3 += tmpSum3;
        }
        return sum1 + sum2 + sum3;
    }
    // 模拟2
    public int projectionArea2(int[][] grid) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < grid.length; i++) {
            int tmpSum2 = 0, tmpSum3 = 0;
            for (int j = 0; j < grid[0].length; j++) {
                // 底面和
                if (grid[i][j] != 0) sum1 += 1;
                // 正面和
                tmpSum2 = Math.max(tmpSum2, grid[i][j]);
                // 侧面和
                tmpSum3 = Math.max(tmpSum3, grid[j][i]);
            }
            sum2 += tmpSum2;
            sum3 += tmpSUm3;
        }
        return sum1 + sum2 + sum3;
    }
}