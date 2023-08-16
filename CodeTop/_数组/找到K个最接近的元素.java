package CodeTop._数组;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/find-k-closest-elements

// 从两边开始排除 n-k 个不满足条件的数字
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = arr.length - 1;

        for (int i = 0; i < arr.length - k; i++) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) l++;
            else r--;
        }

        for (int i = l; i <= r; i++) list.add(arr[i]);
        return list;
    }
}

// 二分 + 两边扩散
class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int r = binarySearch(arr, x);
        int l = r - 1;
        while (k-- > 0) {
            if (l < 0) r++;
            else if (r >= arr.length) l--;
            else if (x - arr[l] <= arr[r] - x) l--;
            else r++;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = l + 1; i < r; i++) list.add(arr[i]);
        return list;
    }

    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

// 百度面试时的思路: 往两边扩散
class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minIdx = 0, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i] - x);
            if (val < minVal) {
                minVal = val;
                minIdx = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[minIdx]);
        
        int l = minIdx - 1, r = minIdx + 1;
        while (k > 1) {
            if (l < 0) r++;
            else if (r > arr.length - 1) l--;
            else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) l--;
            else r++;
            k--;
        }

        for (int i = l; i <= r; i++) list.add(arr[i]);
        return list;
    }
}