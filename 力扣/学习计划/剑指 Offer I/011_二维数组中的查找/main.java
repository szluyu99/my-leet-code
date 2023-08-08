import java.util.Arrays;

// 题解：一维二分
class Solution {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			int index = Arrays.binarySearch(matrix[i], target);
			if (index >= 0) {
				return true;
			}
		}
		return false;
	}
}