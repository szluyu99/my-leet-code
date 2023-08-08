import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/interval-list-intersections/
class Solution {
    public int[][] intervalIntersection(int[][] l1, int[][] l2) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.length && j < l2.length) {
            int[] u1 = l1[i], u2 = l2[j];
            if (u1[0] > u2[1]) j++;
            else if (u2[0] > u1[1]) i++;
            else { 
                list.add(new int[] { Math.max(u1[0], u2[0]), Math.min(u1[1], u2[1]) });
                if (u1[1] < u2[1]) i++;
                else j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}