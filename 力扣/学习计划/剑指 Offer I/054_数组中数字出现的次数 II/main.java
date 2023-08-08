import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/submissions/
 * 暴力 + map
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.containsKey(num));

        for (Integer i : map.keySet())
            if (!map.get(i))
                return i;

        return -1;
    }
}