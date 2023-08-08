package CodeTop._数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/
// 排序 + DP: O(nlogn)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                dp[i] = dp[i - 1];
            } else if (nums[i] == nums[i-1] + 1) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}

// Set: O(n)
// 1. HashSet 保存元素并去重
// 2. 遍历 HashSet, 当集合中不存在 num-1 时, 说明是连续序列起始段, 统计其长度
// 3. 维护每个不同起始元素连续段的最大连续长度
class Solution1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) cur++;
            }
            max = Math.max(max, cur - num + 1);
        }
        return max;
    }
}