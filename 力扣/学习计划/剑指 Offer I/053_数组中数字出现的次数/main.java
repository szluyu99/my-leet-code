import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 暴力 + set
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}