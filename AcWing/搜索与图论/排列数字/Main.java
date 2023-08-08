package AcWing.搜索与图论.排列数字;

import java.util.*;

class Main {
    final static int N = 10;
    static int n;
    static int[] path = new int[N];
    static boolean[] used = new boolean[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) 
                System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                path[u] = i;
                used[i] = true;
                dfs(u + 1);
                used[i] = false;
            }
        }
    }
}