package CodeTop.N皇后;

import java.util.ArrayList;
import java.util.List;

// N 皇后 https://leetcode.cn/problems/n-queens/
// 八皇后 https://leetcode.cn/problems/eight-queens-lcci/submissions/
// N 皇后 II https://leetcode.cn/problems/n-queens-ii/submissions/

// 搜索每一格的 DFS
class Solution {
    final int N = 10;
    List<List<String>> res = new ArrayList<>();
    char[][] g = new char[N][N];
    boolean[] row = new boolean[N];
    boolean[] col = new boolean[N];
    boolean[] dg = new boolean[N + N];
    boolean[] udg = new boolean[N + N];
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        // 初始化
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                g[i][j] = '.';
        dfs(0, 0, 0);
        return res;
    }

    // 搜索每一格
    void dfs(int x, int y, int c) {
        // 换行
        if (y == n) {
            y = 0;
            x++;
        }
        // 扫描到最后一行且放了 n 个皇后
        if (x == n) {
            if (c == n) {
                List<String> tmpList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) 
                        sb = sb.append(g[i][j]);
                    tmpList.add(sb.toString());
                }
                res.add(tmpList);
            }
            return;
        }
        // 不放皇后
        dfs(x, y + 1, c);
        // 放皇后
        if (!row[x] && !col[y] && !dg[x + y] && !udg[y - x + n]) {
            row[x] = col[y] = dg[x + y] = udg[y - x + n] = true;
            g[x][y] = 'Q';
            dfs(x, y + 1, c + 1);
            row[x] = col[y] = dg[x + y] = udg[y - x + n] = false;
            g[x][y] = '.';
        }
    }
}

// 按行进行 DFS，每次搜索时遍历当前行的每一列
class Solution1 {
    final int N = 10;
    List<List<String>> res = new ArrayList<>();
    char[][] g = new char[N][N];
    boolean[] col = new boolean[N];
    boolean[] dg = new boolean[N + N];
    boolean[] udg = new boolean[N + N];
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        // 初始化
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                g[i][j] = '.';
        dfs(0);
        return res;
    }

    // 按行搜索，u 表示当前搜索的行
    void dfs(int u) {
        // 搜索完了所有行
        if (u == n) {
            List<String> tmpList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) 
                    sb = sb.append(g[i][j]);
                tmpList.add(sb.toString());
            }
            res.add(tmpList); 
            return;
        }
        // 遍历当前行的每一列
        int x = u;
        for (int y = 0; y < n; y++) {
            if (!col[y] && !dg[x + y] && !udg[y - x + n]) {
                col[y] = dg[x + y] = udg[y - x + n] = true;
                g[x][y] = 'Q';
                dfs(u + 1);
                col[y] = dg[x + y] = udg[y - x + n] = false;
                g[x][y] = '.';
            }
        }
    }
}
