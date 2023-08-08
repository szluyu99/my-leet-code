import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/reconstruct-itinerary
class Solution {
    List<String> res = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src))
                map.put(src, new PriorityQueue<>());
            map.get(src).add(dst);
        }
        // 查看存储的数据
        // map.forEach((k, v) -> {
        //     System.out.print("k = " + k + "  ");
        //     v.forEach(e -> System.out.print(" v = " + e + " "));
        //     System.out.println();
        // });
        dfs("JFK");
        return res;
    }

    void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty())
            dfs(pq.poll());
        res.add(0, src);
    }
}