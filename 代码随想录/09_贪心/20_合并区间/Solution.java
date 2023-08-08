import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
        List<int[]> list = new ArrayList<>();
        // 每个区间的 起点 和 终点
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) { // 当前区间可以和上一个区间合并
                end = Math.max(end, intervals[i][1]);
            } else { // 当前区间无法和上一个区间合并
                list.add(new int[] { start, end }); // 添加当前区间
                start = intervals[i][0]; // 更新起点
                end = intervals[i][1]; // 更新终点
            }
        }
        list.add(new int[] { start, end }); // 最后一个区间

        return list.toArray(new int[list.size()][]);
    }
}