import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/intersection-of-two-arrays/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) map[n]++;
        for (int n : nums2) {
            if (map[n] != 0) {
                list.add(n);
                map[n] = 0;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res; 
    }
}