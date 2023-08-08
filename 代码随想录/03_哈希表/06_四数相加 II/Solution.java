import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/4sum-ii/
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n1 : nums1)
            for (int n2 : nums2)
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
        for (int n3 : nums3)
            for (int n4 : nums4)
                if (map.containsKey(-n3 - n4))
                    count += map.get(-n3 - n4);
        return count;
    }
}