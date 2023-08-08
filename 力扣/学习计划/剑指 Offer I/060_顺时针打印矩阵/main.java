/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 暴力
 */
class Solution {
    // 已访问标志
    public static final int FLAG = -952861280; 
    public int[] spiralOrder(int[][] matrix) {
        // 边界情况
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[] {};

        // x - row, y - column
        int x = matrix.length, y = matrix[0].length;
        // 当前访问的位置
        int curX = 0, curY = 0;
        // 存储结果的数组
        int[] res = new int[x * y];
        // 从 [0][0] 开始, 默认已访问
        res[0] = matrix[0][0];
        matrix[0][0] = FLAG;

        // idx - 结果数组的索引, direction - 0123 右下左上
        int idx = 0, direction = 0; 
        while (true) {
            if (direction == 0) { // 右
                // 当前方向满足条件就一直走
                while (curY + 1 < y && matrix[curX][curY + 1] != FLAG) {
                    curY++;
                    res[++idx] = matrix[curX][curY];
                    matrix[curX][curY] = FLAG;
                }
                // 下个方向满足条件才走, 否则直接结束
                if (curX + 1 < x && matrix[curX + 1][curY] != FLAG)
                    direction = 1;
                else break;
            } else if (direction == 1) { // 下
                while (curX + 1 < x && matrix[curX + 1][curY] != FLAG) {
                    curX++;
                    res[++idx] = matrix[curX][curY];
                    matrix[curX][curY] = FLAG;
                }
                if (curY - 1 >= 0 && matrix[curX][curY - 1] != FLAG)
                    direction = 2;
                else break;
            } else if (direction == 2) { // 左
                while (curY - 1 >= 0 && matrix[curX][curY - 1] != FLAG) {
                    curY--;
                    res[++idx] = matrix[curX][curY];
                    matrix[curX][curY] = FLAG;
                }
                if (curX - 1 >= 0 && matrix[curX - 1][curY] != FLAG)  
                    direction = 3;
                else break;
            } else if (direction == 3) { // 上
                while (curX - 1 >= 0 && matrix[curX - 1][curY] != FLAG) {
                    curX--;
                    res[++idx] = matrix[curX][curY];
                    matrix[curX][curY] = FLAG;
                }
                if (curY + 1 < y && matrix[curX][curY + 1] != FLAG) 
                    direction = 0;
                else break;
            }
        }
        return res;
    }
}