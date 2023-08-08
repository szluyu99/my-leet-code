import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 将腐烂的橘子放到队列
        int count = 0; // 新鲜橘子的个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    count++;
                else if (grid[i][j] == 2)
                    queue.offer(new int[] { i, j });
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int round = 0; // 橘子腐烂的时间
        // 当没有新鲜橘子 或者 队列为空 停止循环
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0], y = orange[1];
                // 边界内某个方向有新鲜橘子, 则遍历
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j], newY = y + dy[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                            grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // 新鲜橘子变腐烂
                        count--; // 新鲜橘子数量减少
                        queue.offer(new int[] { newX, newY });
                    }
                }
            }
        }
        // 能腐烂的橘子都腐烂后, 新鲜橘子的数量还 > 0, 说明无法腐烂, 返回 - 1
        return count > 0 ? -1 : round;
    }
}
