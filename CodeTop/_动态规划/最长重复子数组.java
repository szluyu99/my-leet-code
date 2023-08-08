package CodeTop._动态规划;

// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/

// DP 数组多开一圈
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]: nums1 以 i 结尾的数组和 nums2 以 j 结尾的数组的最长子数组长度
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}

// DP 数组不多开一圈
class Solution1 {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]: nums1 以 i 结尾的数组和 nums2 以 j 结尾的数组的最长子数组长度
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            if (nums1[i] == nums2[0]) {
                maxLen = 1;
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums1[0] == nums2[j]) {
                maxLen = 1;
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}