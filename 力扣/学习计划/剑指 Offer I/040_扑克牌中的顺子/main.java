import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
class Solution {
    /**
     * 找出 max, min 并判断 max - min >= 5 为 false 否则为 true
     * 遍历时通过 Set 判断是否有 0 以外的重复元素，有则 false
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            // 跳过大小王
            if (num == 0)  continue;
            // 若有重复，直接返回 false
            if (set.contains(num)) return false;
            set.add(num); 
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return max - min < 5;
    }
}