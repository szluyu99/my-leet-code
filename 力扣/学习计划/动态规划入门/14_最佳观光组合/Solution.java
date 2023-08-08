// https://leetcode.cn/problems/best-sightseeing-pair/
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        for (int i = 0, j = 1; j < values.length; j++) {
            res = Math.max(res, values[i] + values[j] + i - j);
            if (values[i] + i - j < values[j]) i = j;
        }        
        return res;
    }
}

class Solution1 {
    // values[i] + values[j] + i - j
    // 上式等价于 (values[i] + i) + (values[j] -j)
    // 由于已经确定 i < j
    // 相当于我们只要遍历 j, 每次能拿到当前的 (values[j] - j)
    // 同时不停的更新 (values[i] + i) 的最大值即可
    public int maxScoreSightseeingPair(int[] values) {
        int maxI = -1, res = -1;
        for (int j = 1; j < values.length; j++) {
            // i < j, 所以 i 最多只能维护到 j 的前一位
            maxI = Math.max(maxI, values[j - 1] + j - 1);
            res = Math.max(res, maxI + values[j] - j);
        }
        return res;
    }
}