package AcWing.数据结构.队列.单调队列;

import java.util.Scanner;

// 超时
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int[] q = new int[n];
        int tt = -1, hh = 0;
        for (int i = 0; i < n; i++) { // 单调递增队列
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[i] <= a[q[tt]]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        } 
        
        System.out.println();
        
        tt = -1; hh = 0;
        for (int i = 0; i < n; i++) { // 单调递减队列
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[i] >= a[q[tt]]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
    }
}

