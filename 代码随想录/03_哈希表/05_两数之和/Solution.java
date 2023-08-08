import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/two-sum/
// 哈希
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] { i, map.get(target - nums[i]) };
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}