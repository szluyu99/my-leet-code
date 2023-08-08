package AcWing.基础算法.排序.归并排序;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        mergeSort(arr, 0, n - 1);
        
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }    
    
    public static void mergeSort(int[] q, int l, int r) {
		// 递归结束条件
        if (l >= r) return;

		// 确定分界点
        int mid = (l + r) >> 1;

		// 递归排序左右两部分
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

		// 归并
        int [] tmp = new int[r - l + 1]; // 这里不用开太大的数组，正好够用就行
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];

		// 赋值
        for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    }
}