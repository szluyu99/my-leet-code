import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /**
     * 数组排序
     */
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingDouble(o -> o[0] * o[0] + o[1] * o[1]));
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = points[i];
        return res;
    }
}