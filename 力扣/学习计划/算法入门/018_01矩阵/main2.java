import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 先找出在 0 边上的所有的 1，然后把这些 1 放到队列里，后续BFS的时候就只关心 1 的值。
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 首先将 0 边上的 1 入队
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };
        Queue<int[]> queue = new LinkedList<>();

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n
                                && matrix[x][y] == 1 && res[x][y] == 0) {
                            // 在 0 边上的 1, 加上 res[x][y] == 0 防止重复入队
                            res[x][y] = 1;
                            queue.offer(new int[] { x, y });
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == 1 && res[newX][newY] == 0) {
                    res[newX][newY] = res[x][y] + 1;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }

        return res;
    }
}