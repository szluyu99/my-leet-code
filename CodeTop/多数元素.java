package CodeTop;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = nums[0], maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > maxCount) {
                maxCount = map.get(nums[i]);
                maxNum = nums[i];
            }
        }
        return maxNum;
    }
}