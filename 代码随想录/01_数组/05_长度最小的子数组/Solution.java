// https://leetcode.cn/problems/minimum-size-subarray-sum/
// 滑动窗口（双指针）
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[l] == target) return 1; // 剪枝
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res % Integer.MAX_VALUE;
    }
}

// 提高要求: O(nlogn) ---> 前缀和 + 二分搜索