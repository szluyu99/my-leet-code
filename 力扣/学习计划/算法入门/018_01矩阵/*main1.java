import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 首先将所有的 0 入队, 并且将 1 的位置设置为 -1, 表示该位置未被访问过
 * 遍历队列中的 0, 如果四邻域的点是 -1, 表示这个点是没有访问过的 1
 * 这个点到 0 的距离更新成 matrix[x][y] + 1
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 入队, 并且将 1 的位置设置为 -1, 表示该位置未被访问过
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[] { i, j });
                else matrix[i][j] = -1;
            }
        }
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                // 如果四邻域的点是 -1, 表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离可以更新成 matrix[x][y] + 1
                if (newX >= 0 && newX < m && newY >= 0 && newY < n // 没有越界
                        && matrix[newX][newY] == -1) { // 没有访问过
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }
        return matrix;
    }
}