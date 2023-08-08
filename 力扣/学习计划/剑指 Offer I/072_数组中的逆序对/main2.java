/**
 * 动态规划思想(超时)
 */
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 1) return 0;
        // dp[i] - 第i个位置的逆序对总数
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) 
                if (nums[j] > nums[i]) 
                    count++;
            dp[i] = dp[i - 1] + count;
        }        
        return dp[nums.length - 1];
    }
}

// [7] - 0
// [7, 5] - 1
// [7, 5, 6] - 1 + 1 = 2