package AcWing.搜索与图论.N皇后;

import java.util.Scanner;

public class Main {
    static final int N = 20;

    static int n;
    static char[][] g = new char[N][N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(g[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }
        int x = u;
        for (int y = 0; y < n; y++) {
            if (!col[y] && !dg[y - x + n] && !udg[x + y]) {
                // 标记已访问
                col[y] = dg[y - x + n] = udg[x + y] = true;
                g[x][y] = 'Q';
                // 继续搜索
                dfs(u + 1);
                // 回溯
                g[x][y] = '.';
                col[y] = dg[y - x + n] = udg[x + y] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';
        dfs(0);
    }
}
