import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/intersection-of-two-arrays-ii/
// 一个哈希
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        for (int n : nums1) map[n]++;
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (map[n] != 0) {
                list.add(n);
                map[n]--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}
// 两个哈希
class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for (int n : nums1) map1[n]++;
        for (int n : nums2) map2[n]++;

        List<Integer> list = new ArrayList<>();
        // 遍历长的元素
        for (int n : (nums1.length > nums2.length) ? nums1 : nums2) {
            if (map1[n] != 0 && map2[n] != 0) {
                if (map1[n] < map2[n]) 
                    while (map1[n] -- > 0) list.add(n);
                else 
                    while (map2[n] -- > 0) list.add(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res; 
    }
}