/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 713. 乘积小于 K 的子数组
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) return 0;
        // prod 存储 nums[l] ~ nums[r] 的乘积
        int prod = 1, res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k) prod /= nums[l++];
            res += r - l + 1;
        }
        return res;
    }
}
