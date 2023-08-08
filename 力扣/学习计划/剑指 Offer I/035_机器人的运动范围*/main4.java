class Solution {
    /**
     * DSF 返回值写到递归中
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, visited, 0, 0, k);
    }

    int dfs(int m, int n, boolean[][] visited, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || computeSum(i, j) > k)
            return 0;
        visited[i][j] = true;
        int right = dfs(m, n, visited, i + 1, j, k);
        int down = dfs(m, n, visited, i, j + 1, k);
        return down + right + 1;
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