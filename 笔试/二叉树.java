package 笔试;

import java.util.Scanner;

public class 二叉树 {
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        getMax(a, n, 1, 0);
        System.out.println(max);
    }

    static void dfs(int[]a, int n, int u, int sum) {
        if (u > n) return;
        sum += a[u];
        max = Math.max(max, sum);
        getMax(a, n, u * 2, sum);
        getMax(a, n, u * 2 + 1, sum);
        sum -= a[u];
    }
}
