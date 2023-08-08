import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> res = new ArrayList<>();
    boolean up = false, down = false, left = false, right = false; // 当前方向
    char[][] g;
    int num;
    int n, m;

    public int[][] ballGame(int num, String[] plate) {
        this.num = num;
        this.n = plate.length;
        this.m = plate[0].length();
        g = new char[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = plate[i].charAt(j);

        // 上 [0, 1] -> [0, m - 2]
        for (int i = 1; i <= m - 2; i++) {
            resetDir();
            down = true;
            doGoing(0, i);
        }

        // 左 [1, 0] -> [n - 2, 0]
        for (int i = 1; i <= n - 2; i++) {
            resetDir();
            right = true;
            doGoing(i, 0);
        }

        // 下 [n - 1, 1] -> [n - 1, m - 2]
        for (int i = 1; i <= m - 2; i++) {
            resetDir();
            up = true;
            doGoing(n - 1, i);
        }

        // 右 [1, m - 1] -> [n - 2, m - 1]
        for (int i = 1; i <= n - 2; i++) {
            resetDir();
            left = true;
            doGoing(i, m - 1);
        }

        return res.toArray(new int[res.size()][]);
    }
    
    // 越界检查
    boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 前进！
    void doGoing(int x, int y) {
        if (g[x][y] == 'O' || g[x][y] == 'W' || g[x][y] == 'E') return;
        int cnt = 0;
        int backX = x, backY = y;
        while (check(x, y) && cnt <= num) {
            if (up) x--;
            else if (right) y++;
            else if (down) x++;
            else if (left) y--;

            if (!check(x, y)) return;
            cnt++;

            if (g[x][y] == 'O' && cnt <= num) {
                for (int[] p : res)
                    if (p[0] == backX && p[1] == backY) return;
                res.add(new int[] { backX, backY });
            } else if (g[x][y] == 'E') turnRight();
            else if (g[x][y] == 'W') turnLeft();
        }
    }
    
    // 顺时针
    void turnRight() {
        if (up) {
            right = true;
            up = false;
        } else if (right) {
            down = true;
            right = false;
        } else if (down) {
            left = true;
            down = false;
        } else if (left) {
            up = true;
            left = false;
        }
    }
    
    // 逆时针
    void turnLeft() {
        if (up) {
            left = true;
            up = false;
        } else if (right) {
            up = true;
            right = false;
        } else if (down) {
            right = true;
            down = false;
        } else if (left) {
            down = true;
            left = false;
        }
    }

    // 重置方向
    void resetDir() {
        up = false;
        down = false;
        left = false;
        right = false;
    }
}