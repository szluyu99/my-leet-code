package CodeTop._数组;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/

// 链表模拟: 勉强通过
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);
        
        int cur = 0;
        while (list.size() > 1) {
            cur = (cur + m - 1) % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }
}

// 数组模拟: 超时
class Solution1 {
    public int lastRemaining(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        int cur = 0;
        int count = n;
        while (count-- > 1) {
            for (int i = 1; i < m; i++) {
                while (arr[cur] == -1) cur = (cur + 1) % n;
                cur = (cur + 1) % n;
                while (arr[cur] == -1) cur = (cur + 1) % n;
            }
            arr[cur] = -1;
            cur = (cur + 1) % n;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) return i;
        }
        return -1;
    }
}
