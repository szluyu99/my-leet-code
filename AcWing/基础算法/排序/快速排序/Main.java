package AcWing.基础算法.排序.快速排序;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        quickSort(arr, 0, n - 1);
        
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        
        int i = l - 1, j = r + 1, x = q[(l + r) >> 1];
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}