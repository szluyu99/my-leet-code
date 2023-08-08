import java.util.Arrays;

// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
// DP
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) dp[i + 1] = dp[i] + 1;
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}

// 贪心
class Solution1 {
    public int findLengthOfLCIS(int[] nums) {
        int cnt = 1, res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) cnt++;
            else cnt = 1;
            res = Math.max(res, cnt);
        }
        return res;
    }
}