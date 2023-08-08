import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/top-k-frequent-elements/
// 优先级队列<二元对<数字, 频率>>
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()); // 大根堆
        for (var entry : map.entrySet()) pq.offer(entry);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll().getKey();
        return res;
    }
}

// 排序
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        // 对 map 的 value 进行排序
        var list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = list.get(i).getKey();
        return res;
    }
}

// 维护大小为 k 的小根堆
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            if (pq.size() < k) pq.add(n);
            else if (map.get(n) > map.get(pq.peek())) {
                pq.poll();
                pq.add(n);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }
}