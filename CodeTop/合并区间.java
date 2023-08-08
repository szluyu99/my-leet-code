package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int a = list.get(list.size() - 1)[0], b = list.get(list.size() - 1)[1];
            int c = intervals[i][0], d = intervals[i][1];
            if (b >= c) {
                if (d <= b) continue;
                list.set(list.size() - 1, new int[] { a, d });
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}