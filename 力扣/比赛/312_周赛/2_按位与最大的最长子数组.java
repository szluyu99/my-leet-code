import java.util.Arrays;

class Solution {
    public int longestSubarray(int[] nums) {
        // 数组元素最大值
        int maxValue = nums[0];
        for (int n : nums)
            maxValue = Math.max(maxValue, n);

        int n = nums.length;
        // dp[i] 以 i 结尾的位与最大的子数组的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // max 记录出现过的按位与的最大值, cur 记录当前按位与的值
        int res = 1, max = nums[0], cur = nums[0];
        for (int i = 1; i < n; i++) {
            cur &= nums[i];
            // 注意按位与的值需要 >= 数组元素最大值
            if (cur >= max && cur >= maxValue) {
                max = cur;
                dp[i] = dp[i - 1] + 1;
            } else cur = nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}