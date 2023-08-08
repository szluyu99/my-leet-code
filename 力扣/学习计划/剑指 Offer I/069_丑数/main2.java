import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 优先级队列
 * 1. 将丑数 1 放入优先队列
 * 2. 不断地从优先队列弹出最小的丑数，将其独立与 2、3、5 相乘后得到的 3 个新丑数，用 HashSet 进行去重后放入优先队列
 * 3. 弹出 n 次后得到第 n 个丑数
 */
class Solution {
    private static final int[] factors = new int[] { 2, 3, 5 };

    public int nthUglyNumber(int n) {
        // 1 是最基础的丑数
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>() {{ add(1L); }};
        Set<Long> set = new HashSet<>() {{ add(1L); }};

        long ugly = 1l;
        for (int i = 0; i < n; i++) {
            // 获取优先队列中的最小的丑数
            ugly = priorityQueue.poll(); 
            for (int j = 0; j < factors.length; j++) {
                // 最小的丑数与 2,3,5 相乘得到 3 个新的丑数
                long newUgly = ugly * factors[j];
                // 去重后放到优先队列
                if (set.add(newUgly))
                    priorityQueue.add(newUgly);
            }
        }
        return (int) ugly;
    }
}