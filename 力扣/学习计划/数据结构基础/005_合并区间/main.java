class Solution {
    public int[][] merge(int[][] intervals) {
        // 按照数组中第一个元素排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 计算合并
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 对于 [1,3] 和 [2,6], 比较 3 和 2, 3 >= 2 则合并
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i] = new int[] {
                        intervals[i - 1][0], Math.max(intervals[i - 1][1], intervals[i][1]) };
            } else // 不能合并则将上一个合并结果加入
                res.add(intervals[i - 1]);
        }
        res.add(intervals[intervals.length - 1]);

        // List<int[]> ---> int[][]
        int[][] resArr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++)
            resArr[i] = res.get(i);
        return resArr;
    }
}