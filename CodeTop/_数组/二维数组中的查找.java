package CodeTop._数组;

// https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else if (matrix[i][j] == target) return true;
        }
        return false;
    }
}