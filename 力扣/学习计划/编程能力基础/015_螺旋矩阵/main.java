/**
 * https://leetcode-cn.com/problems/spiral-matrix/submissions/
 * 蛇形数组
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int direction = 1; // 1234 - 右下左上
        boolean[][] visited = new boolean[m][n]; // 记录访问过的坐标, 防止重复访问
        int x = 0, y = 0; // 当前访问坐标
        // 初始化第一个位置
        res.add(matrix[0][0]);
        visited[0][0] = true;
        while (res.size() < m * n) {
            // 一直往 右 走
            while (direction == 1 && y + 1 < n && !visited[x][y + 1]) {
                res.add(matrix[x][++y]);
                visited[x][y] = true;
            }
            direction = 2; // 更改方向为 下

            // 一直往 下 走
            while (direction == 2 && x + 1 < m && !visited[x + 1][y]) {
                res.add(matrix[++x][y]);
                visited[x][y] = true;
            }
            direction = 3; // 更改方向为 左

            // 一直往 左 走
            while (direction == 3 && y - 1 >= 0 && !visited[x][y - 1]) {
                res.add(matrix[x][--y]);
                visited[x][y] = true;
            }
            direction = 4; // 更改方向为 上

            // 一直往 上 走
            while (direction == 4 && x - 1 >= 0 && !visited[x - 1][y]) {
                res.add(matrix[--x][y]);
                visited[x][y] = true;
            }
            direction = 1; // 更改方向为 右
        }
        return res;
    }
}