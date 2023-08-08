import javax.management.openmbean.SimpleType;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * 动态规划
 */
class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1; // 基础丑数
        int i = 0, j = 0, k = 0;
        for (int idx = 1; idx < n; idx++) {
            // 任意一个丑数都是由小于它的某一个丑数 *2, *3 或者 *5 得到的
            int tmp = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (tmp == dp[i] * 2) i++;
            if (tmp == dp[j] * 3) j++;
            if (tmp == dp[k] * 5) k++;
            dp[idx] = tmp;
        }
        return dp[n - 1];
    }
}