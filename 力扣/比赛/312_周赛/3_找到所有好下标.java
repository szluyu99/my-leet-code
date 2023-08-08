import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 暴力
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] trend = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i])
                trend[i] = 1; // 递增
            else if (nums[i + 1] < nums[i])
                trend[i] = -1; // 递减
            else
                trend[i] = 0; // 相等
        }

        List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            boolean flag = true;

            for (int j = i - k; j < i - 1; j++) {
                if (trend[j] > 0) {
                    flag = false;
                    i = j + k;
                    break;
                }
            }
            if (!flag)
                continue;

            for (int j = i + 1; j < i + k; j++) {
                if (trend[j] < 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                continue;
            if (flag)
                res.add(i);
        }
        return res;
    }
}

// 动态规划
class Solution1 {
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