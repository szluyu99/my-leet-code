import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.cn/problems/queue-reconstruction-by-height/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 先按身高从高到低排序, 身高一样再按 k 从低到高排序
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> q = new LinkedList<>();
        for (int[] p : people) q.add(p[1], p); // 往指定位置插入元素

        return q.toArray(new int[people.length][]);
    }
}