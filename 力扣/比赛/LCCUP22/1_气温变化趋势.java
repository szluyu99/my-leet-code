class Solution {
    public int temperatureTrend(int[] tA, int[] tB) {
        // dp[i] 以 i 位置结尾的两地天气变化趋势最大
        int[] dp = new int[tA.length + 1];
        int res = 0;
        for (int i = 1; i < tA.length; i++) {
            if (check(tA, tB, i)) dp[i] = dp[i - 1] + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 是否满足 上升 或 下降 或 平稳
    boolean check(int[] tA, int[] tB, int i) {
        return tA[i] > tA[i - 1] && tB[i] > tB[i - 1] // 上升
                || tA[i] < tA[i - 1] && tB[i] < tB[i - 1] // 下降
                || tA[i] == tA[i - 1] && tB[i] == tB[i - 1]; // 平稳
    }
}