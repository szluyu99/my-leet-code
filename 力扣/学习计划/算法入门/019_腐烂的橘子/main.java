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

        int round = 0; // 腐烂的分钟数
        // 当没有新鲜橘子 或者 队列为空 停止循环
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0], y = orange[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) { // 上
                    grid[x - 1][y] = 2;
                    count--; // 每感染一个, 减少新鲜橘子的数量
                    queue.add(new int[] { x - 1, y });
                }
                if (x + 1 < m && grid[x + 1][y] == 1) { // 下
                    grid[x + 1][y] = 2;
                    count--;
                    queue.add(new int[] { x + 1, y });
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) { // 左
                    grid[x][y - 1] = 2;
                    count--;
                    queue.add(new int[] { x, y - 1 });
                }
                if (y + 1 < n && grid[x][y + 1] == 1) { // 右
                    grid[x][y + 1] = 2;
                    count--;
                    queue.add(new int[] { x, y + 1 });
                }
            }
        }
        return count > 0 ? -1 : round;
    }
}