import java.util.Arrays;

// https://leetcode.cn/problems/search-a-2d-matrix/submissions/
// 两次二分搜索, 第一次找到 tartget 所在行, 第二次找到具体位置 O(logmn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        // 对第 0 列进行二分搜索, 找到 matrix[i][0] > target
        int l = -1, r = n; // 注意边界条件
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid < 0 || mid > n) return false; // 越界处理
            if (matrix[mid][0] > target) r = mid;
            else l = mid + 1;
        }
        if (l < 0 || l > n) return false; // 越界处理
        // 对 matrix[i][0] > target 的上一行进行搜索
        return Arrays.binarySearch(matrix[l - 1], target) >= 0;
    }
}

// 从左下角往右上角搜, 大了往右, 小了往上
// 或者从右上角往左下角搜, 大了往左, 小了往下
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从左下角开始, 大了往上, 小了往右
        int n = matrix.length, m = matrix[0].length;
        int i = n - 1, j = 0; // 左下角是起点
        while (i >= 0 && j <= m - 1) {
            if (matrix[i][j] > target) i--; // 大了往上
            else if (matrix[i][j] < target) j++; // 小了往右
            else return true;
        }
        return false;
    }
}

// 一次二分查找, 将矩阵每行拼接在上一行末尾, 则会得到一个升序数组
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int x = matrix[mid / m][mid % m]; // 位置映射后的元素
            if (x < target) l = mid + 1;
            else if (x > target) r = mid - 1;
            else return true;
        }
        return false;
    }
}