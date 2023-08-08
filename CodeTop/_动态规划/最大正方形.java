package CodeTop._动态规划;

// DP
class Solution {
    public int maximalSquare(char[][] g) {
        int m = g.length, n = g[0].length;
        // dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长
        int[][]dp = new int[m + 1][n + 1];

        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
        
    }
}

// 暴力（超时）
class Solution1 {
    public int maximalSquare(char[][] g) {
        int n = g.length, m = g[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '0') continue;
                if (maxArea < 1) maxArea = 1;

                int maxLen = Math.min(n - i, m - j);
                if (maxLen * maxLen <= maxArea) continue;


                for (int k = maxLen; k >= Math.sqrt(maxArea); k-- ) {
                    boolean isRectangle = true;
                    for (int ii = i; ii < i + k; ii++) {
                        for (int jj = j; jj < j + k; jj++) {
                            if (g[ii][jj] == '0') {
                                isRectangle = false;
                                break;
                            };
                        }
                        if (!isRectangle) break;
                    }
                    if (isRectangle) {
                        maxArea = Math.max(maxArea, k * k);
                        break;
                    }
                    if ((k - 1) * (k - 1) <= maxArea) break;
                }

            }
        } 
        return maxArea;
    }
}