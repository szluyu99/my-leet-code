// https://leetcode-cn.com/problems/maximum-product-subarray/submissions/
// 从前往后乘找最大, 从后往前乘找最大, 比较两者
class Solution1 {
    // 优化上面写法
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // maxF - 从前往后乘的最大值, maxB - 从后往前乘的最大值
        int res = nums[0], maxF = 1, maxB = 1;
        for (int i = 0; i < n; i++) {
            maxF = (maxF == 0) ? nums[i] : maxF * nums[i];
            maxB = (maxB == 0) ? nums[n - i - 1] : maxB * nums[n - i - 1];
            res = Math.max(res, Math.max(maxF, maxB));
        }
        return res;
    }
}

// DP
class Solution {
    public int maxProduct(int[] nums) {
        // maxDp[i] 表示以 i 位置结尾的连续子数组的最大乘积
        int[] maxDp = new int[nums.length];
        // minDp[i] 表示以 i 位置结尾的连续子数组的最小乘积
        int[] minDp = new int[nums.length];
        int res = maxDp[0] = minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }

    // 优化
    public int maxProduct1(int[] nums) {
        int res = nums[0], imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            int tempImax = imax;
            imax = Math.max(nums[i], Math.max(imax * nums[i], imin * nums[i]));
            imin = Math.min(nums[i], Math.min(tempImax * nums[i], imin * nums[i]));
            res = Math.max(res, imax);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        // maxDP[i] 表示以 i 位置结尾的连续子数组的最大乘积
        int[] maxDP = new int[n];
        // minDP[i] 表示以 i 位置结尾的连续子数组的最小乘积
        int[] minDP = new int[n];
        int res = maxDP[0] = minDP[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(minDP[i - 1] * nums[i], nums[i]);
            } else {
                maxDP[i] = Math.max(minDP[i - 1] * nums[i], nums[i]);
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], nums[i]);
            }
            res = Math.max(res, maxDP[i]);
        }
        return res;
    }
}