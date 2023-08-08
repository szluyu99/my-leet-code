import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/
class Solution {
    final int N = 20;
    List<List<String>> res = new ArrayList<>();
    char[][] g = new char[N][N];
    boolean[] col = new boolean[N];
    boolean[] dg = new boolean[N];
    boolean[] udg = new boolean[N];
    int n;

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';
        this.n = n;
        dfs(0);
        return res;
    }

    // 当前遍历的行
    void dfs(int u) {
        if (u == n) {
            List<String> tmpList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++)
                    sb.append(g[i][j]);
                tmpList.add(sb.toString());
            }
            res.add(tmpList);
        }
        int x = u;
        for (int y = 0; y < n; y++) {
            if (col[y] || dg[y - x + n] || udg[y + x]) continue;
            col[y] = dg[y - x + n] = udg[y + x] = true;
            g[x][y] = 'Q';
            dfs(x + 1);
            col[y] = dg[y - x + n] = udg[y + x] = false;
            g[x][y] = '.';
        }
    }
}