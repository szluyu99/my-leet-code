import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.cn/problems/number-of-islands/
// DFS
class Solution {
    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };
    char[][] g;
    int m, n;

    public int numIslands(char[][] g) {
        this.g = g;
        this.m = g.length;
        this.n = g[0].length;

        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == '1')
                    res += dfs(i, j);

        return res;
    }

    int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] != '1')
            return 0;
        g[i][j] = '2'; // 标记为 '2' 表示已访问
        for (int k = 0; k < 4; k++)
            dfs(i + dx[k], j + dy[k]);
        return 1;
    }
}

// BFS
class Solution1 {
    public int numIslands(char[][] g) {
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == '1') {
                    bfs(g, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(char[][] g, int i, int j) {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == '1') {
                g[x][y] = '0';
                q.add(new int[] { x + 1, y });
                q.add(new int[] { x - 1, y });
                q.add(new int[] { x, y + 1 });
                q.add(new int[] { x, y - 1 });
            }
        }
    }

}