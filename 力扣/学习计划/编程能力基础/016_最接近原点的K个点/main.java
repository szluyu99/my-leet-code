import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 最接近原点的 K 个点
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> cmp(a, b));
        // 遍历的同时维护 size = k 的优先级队列
        for (int i = 0; i < points.length; i++) {
            // 堆中元素数量 < k, 直接放入
            if (queue.size() < k)
                queue.add(points[i]);
            // 堆中已经有 k 个元素, 比较堆顶元素和当前遍历元素
            else {
                int[] temp = queue.peek();
                if (cmp(points[i], temp) > 0) {
                    queue.poll();
                    queue.add(points[i]);
                }
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
            res[i] = queue.poll();
        return res;
    }

    int cmp(int[] a, int[] b) {
        return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
    }
}
