/**
 * 最小差值 II
 * https://leetcode-cn.com/problems/smallest-range-ii/
 */
/**
 * 贪心
 */
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = Math.min(nums[0] + k, nums[i] - k);
            int max = Math.max(nums[n - 1] - k, nums[i - 1] + k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}