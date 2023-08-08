package CodeTop._动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/
// DP
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // maxDP[i] 表示以 i 结尾的乘积最大值
        int[] maxDP = new int[n];
        maxDP[0] = nums[0];
        // minDP[i] 表示以 i 结尾的乘积最小值
        int[] minDP = new int[n];
        minDP[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(nums[i], maxDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], minDP[i - 1] * nums[i]);
            } else {
                maxDP[i] = Math.max(nums[i], minDP[i - 1] * nums[i]);
                minDP[i] = Math.min(nums[i], maxDP[i - 1] * nums[i]);
            }
            max = Math.max(max, maxDP[i]);
        }
        return max;
    }
}

// 由于存在负数，那么会导致最大的变最小的，最小的变最大的
// 因此还需要维护当前最小值 imin
class Solution1 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // 当前值是负数, 会导致最大最小值互换
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}