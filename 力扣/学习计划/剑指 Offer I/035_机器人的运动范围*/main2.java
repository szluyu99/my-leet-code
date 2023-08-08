class Solution {
    /**
     * DFS
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * 深度优先搜索
     * @param i 当前搜索的行索引
     * @param j 当前搜索的列索引
     * @param m 题目给的矩阵行数
     * @param n 题目给的矩阵列数
     * @param k 题目给的与数位和比较的数字
     * @param visited 已经搜索过的路径
     * @return
     */
    int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || computeSum(i, j) > k)
            return 0;
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
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