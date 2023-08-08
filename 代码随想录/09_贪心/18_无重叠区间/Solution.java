import java.util.Arrays;

// https://leetcode.cn/problems/non-overlapping-intervals/
// 贪心: 计算最多能组成的不重叠的区间个数, 然后用区间总个数减去不重叠区间的个数
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 1;

        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            // 重叠
            if (intervals[i][0] < end) continue;
            // 未重叠
            end = intervals[i][1];
            cnt++;
        }

        return intervals.length - cnt;
    }
}