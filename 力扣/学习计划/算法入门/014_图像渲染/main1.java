import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
class Solution {
    int[] dx = { 1, 0, 0, -1 };
    int[] dy = { 0, 1, -1, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 保存初始颜色
        int originColor = image[sr][sc];
        // 如果初始颜色和新上的颜色相同, 直接返回原数组
        if (originColor == newColor) return image;

        // 初始位置入队
        Queue<int[]> queue = new LinkedList<>() {{ offer(new int[] { sr, sc }); }};
        // 上色
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                // 没有越界, 并且还未上过色, 才继续搜索
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length
                        && image[mx][my] == originColor) {
                    queue.offer(new int[] { mx, my });
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}