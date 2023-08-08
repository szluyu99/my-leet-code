package CodeTop;

// https://leetcode.cn/problems/search-a-2d-matrix-ii/
// 从右上往左下看，是一个二叉搜索树
class Solution {
    public boolean searchMatrix(int[][] g, int target) {
        int i = 0, j = g[0].length - 1;

        while (i < g.length && j >= 0) {
            if (g[i][j] > target) j--;
            else if (g[i][j] < target)  i++;
            else return true;
        }
        
        return false;
    }
}

// 二分（怎么反而更慢）
class Solution1 {
    public boolean searchMatrix(int[][] g, int target) {
        int m = g.length, n = g[0].length;
        int y = 0, x = 0;

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r +1 >> 1;
            if (g[0][mid] <= target) l = mid;
            else r = mid - 1;
        }
        if (g[0][r] == target) return true;
        y = r;

        l = 0;
        r = m - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (g[mid][0] <= target) l = mid;
            else r = mid - 1;
        }
        if (g[r][0] == target) return true;
        x = r;

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (g[i][j] == target) return true;
            }
        }

        return false;
    }
}