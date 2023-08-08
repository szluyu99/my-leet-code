/**
 * https://leetcode-cn.com/problems/triangle/submissions/
 * 三角形最小路径和
 */
/**
 * 动态规划 + 从上往下
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();

        // 特殊情况
        if (m == 1)
            return triangle.get(0).get(0);
        if (m == 2)
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));

        // dp[i][j] 矩阵 i, j 位置的三角形的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = dp[0][0] + triangle.get(1).get(0);
        dp[1][1] = dp[0][0] + triangle.get(1).get(1);

        for (int i = 2; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int curNum = triangle.get(i).get(j);
                // 首元素特殊处理
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + curNum;
                    continue;
                }
                // 尾元素特殊处理
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + curNum;
                    continue;
                }
                dp[i][j] = curNum + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++)
            min = Math.min(min, dp[m - 1][i]);

        return min;
    }
}