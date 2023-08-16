package CodeTop._数组;

import java.util.Arrays;

// https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/

// 常规排序
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}

// 计数排序
class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[]{};

        int[] m = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            m[arr[i]]++;
        }
        int count = 0;
        int[] result = new int[k];
        for (int i = 0; i < m.length; i++) {
            while (m[i] > 0 && count < k) {
                result[count++] = i;
                m[i]--;
            }
            if (count == k) break;
        }
        return result;
    }
}