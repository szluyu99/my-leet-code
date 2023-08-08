/**
 * 我的 DFS 思路
 */
class Solution {
    int res = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, visited, 0, 0, k);
        return res;
    }

    void dfs(int m, int n, boolean[][] visited, int i, int j, int k) {
        // 边界情况
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || computeSum(i, j) > k)
            return;
        res++;
        visited[i][j] = true;
        dfs(m, n, visited, i + 1, j, k);
        dfs(m, n, visited, i - 1, j, k);
        dfs(m, n, visited, i, j + 1, k);
        dfs(m, n, visited, i, j - 1, k);
    }

    /**
     * 计算 m 与 n 的数位和
     */
    int computeSum(int m, int n) {
        int sum = 0;
        while (m > 0 || n > 0) {
            sum += (m % 10 + n % 10);
            m /= 10;
            n /= 10;
        }
        return sum;
    }
}