/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 908. 最小差值 I
 */
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        return min + k > max - k ? 0 : max - k - (min + k);
    }
}