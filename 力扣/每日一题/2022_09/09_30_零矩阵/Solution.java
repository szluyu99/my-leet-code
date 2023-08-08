// https://leetcode.cn/problems/zero-matrix-lcci/
// 模拟
class Solution {
    public void setZeroes(int[][] g) {
        int n = g.length, m = g[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                tmp[i][j] = g[i][j];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] != 0) continue;
                for (int k = 0; k < n; k++) g[k][j] = 0;
                for (int k = 0; k < m; k++) g[i][k] = 0;
            }
        }
    }
}

// 标记行列法
class Solution1 {
    public void setZeroes(int[][] g) {
		int n = g.length, m = g[0].length;
		boolean[] row = new boolean[n];
		boolean[] col = new boolean[m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (g[i][j] == 0) 
					row[i] = col[j] = true;
		// 处理标记为 true 的数据
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (row[i] || col[j])
					g[i][j] = 0;
	}
}