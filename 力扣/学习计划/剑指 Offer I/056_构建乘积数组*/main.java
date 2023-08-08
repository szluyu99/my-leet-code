import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
class Solution {
    /**
     * 暴力（超时）
     */
    public int[] constructArr(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tempProduct = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                tempProduct *= nums[j];
            }
            res[i] = tempProduct; 
        }
        return res;
    }
}