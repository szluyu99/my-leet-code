/**
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * 合并区间
 */
/**
 * 暴力模拟
 */
function merge(intervals: number[][]): number[][] {
    // 先按第一个元素排序
    intervals.sort((a, b) => a[0] - b[0])
    let res = []
    for (let i = 1; i < intervals.length; i++) {
        // 对于 [1,3] 和 [2,6], 比较 3 和 2, 3 >= 2 则合并
        if (intervals[i][0] <= intervals[i - 1][1])
            intervals[i] = [intervals[i - 1][0], Math.max(intervals[i - 1][1], intervals[i][1])]
        else
            // 不能合并则将上一个合并结果加入 
            res.push(intervals[i - 1])
    }
    res.push(intervals[intervals.length - 1])
    return res
};