package 力扣.练习.只出现一次的数字;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/WGki4K/submissions/
class Solution {
    // 哈希
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}