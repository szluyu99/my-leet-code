import java.util.Arrays;

// https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
// 贪心: 
// - 按照左边界排序
// - 重叠时, 上一气球和当前气球视为一个区间, 更新该区间的最小右边界
// - 不重叠时, 上一气球和当前气球为两个不同的区间, 箭的数量+1, 最小右边界改为新区间的
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 1; // 至少需要一支箭
        int end = points[0][1]; // 折叠气球的最小右边界
        for (int i = 1; i < points.length; i++) {
            // 当前气球的左边界 > 最小右边界, 说明不重叠, 箭 + 1
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            }
            // 当前气球的左边界 <= 最小右边界, 说明重叠, 更新最小右边界
            else end = Math.min(end, points[i][1]);
        }
        return res;
    }
}