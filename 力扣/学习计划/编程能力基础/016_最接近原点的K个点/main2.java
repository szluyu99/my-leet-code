import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    /**
     * 优先级队列
     */
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingDouble(o -> o[0] * o[0] + o[1] * o[1]));
        queue.addAll(Arrays.asList(points));

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = queue.poll();
        return res;
    }
}