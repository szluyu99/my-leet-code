import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/


class Solution {
    /**
     * 迭代 + map 
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], nums[i]);
        }
        return 0;
    }
    
    /**
     * 迭代 + 数组
     */
    public int findRepeatNumber2(int[] nums) {
        int[] records = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            records[nums[i]]++;
            if (records[nums[i]] > 1) {
                return nums[i];
            }
        }
        return 0;
    }
    /**
     * 题解：迭代 + set
     */
    public int findRepeatNumber3(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num))
                return num;
            dic.add(num);
        }
        return 0;
    }
}