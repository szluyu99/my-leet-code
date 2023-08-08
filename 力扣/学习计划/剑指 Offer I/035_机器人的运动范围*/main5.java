import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * BFS
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 从左上角坐标[0,0]点开始访问，add方法表示把坐标点加入到队列的队尾
        queue.add(new int[] { 0, 0 });
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            // 判断边界条件
            if (i >= m || j >= n || computeSum(i, j) > k || visited[i][j])
                continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[] { i + 1, j });
            queue.add(new int[] { i, j + 1 });
        }
        return res;
    }

    /**
     * 计算 m 与 n 的数位和
     */
    int computeSum(int m, int n) {
        int sum = 0;
        while (m > 0 || n > 0) {
            sum += (m % 10 + n % 10);
            m /= 10;
            n /= 10;
        }
        return sum;
    }
}