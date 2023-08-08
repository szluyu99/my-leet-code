// https://leetcode-cn.com/problems/delete-and-earn/
class Solution {
    public int deleteAndEarn(int[] nums) {
        // [2, 2, 3, 3, 3, 4] -> [0, 0, 4, 9, 4]
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            trans[nums[i]] += nums[i];
        }
        return rob(trans);
    }

    // 打家劫舍
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}