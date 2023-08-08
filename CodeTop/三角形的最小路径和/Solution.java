package CodeTop.三角形的最小路径和;

import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/triangle/
// 二维 DP 从上往下递推
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        
        // 初始化 DP 数组
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        
        // DP 初始值
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i - 1).get(j - 1);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
                res = Math.min(res, dp[n][i]);
        return res;
    }
}

// 二维 DP 从下往上递推
class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 加 1 可以不用初始化最后一层
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++)
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
        }
        
        return dp[0][0];
    }
}

// 记忆化搜索
class Solution2 {
    final int inf = 2000007;
    List<List<Integer>> triangle;
    int n;
    int[][] mem;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.n = triangle.size();
        this.mem = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) Arrays.fill(mem[i], inf); // 初始化 mem 数组
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i == n) return 0;
        if (mem[i][j] != inf) return mem[i][j];
        mem[i][j] = triangle.get(i).get(j) + Math.min(dfs(i + 1, j), dfs(i + 1, j + 1));;
        return mem[i][j];
    }
}