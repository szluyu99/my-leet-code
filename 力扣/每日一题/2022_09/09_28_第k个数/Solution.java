// https://leetcode.cn/problems/get-kth-magic-number-lcci/
// 三指针
class Solution {
    public int getKthMagicNumber(int k) {
        // dp[i] 表示第 i+1 个数
        int[] dp = new int[k];
        dp[0] = 1;
        // pN 记录乘过 N 的数字的下标
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
            if (dp[i] % 3 == 0) p3++;
            if (dp[i] % 5 == 0) p5++;
            if (dp[i] % 7 == 0) p7++;
        }
        return dp[k - 1];
    }
}