package CodeTop._滑动窗口;

// https://leetcode.cn/problems/minimum-size-subarray-sum/
// 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l);
                sum -= nums[l++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}