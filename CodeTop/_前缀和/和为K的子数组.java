package CodeTop._前缀和;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/subarray-sum-equals-k/
/*
为什么这题不可以用 双指针/滑动窗口：

因为 nums[i] 可以小于 0
- 也就是说右指针 i 向后移 1 位不能保证区间会增大
- 左指针 j 向后移 1 位也不能保证区间和会减小

给定 j，i 的位置没有二段性
*/

// 无下标偏移的前缀和
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sums[i] == k) count++;
            for (int j = i + 1; j < n; j++) {
                if (sums[j] - sums[i] == k) {
                    count++; 
                }
            }
        }

        return count;
    }
}

// 有下标偏移的前缀和
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 注意下标偏移
                if (sums[j + 1] - sums[i] == k) {
                    count++; 
                }
            }
        }

        return count;
    }
}


// 前缀和 + 哈希优化
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        // key-前缀和, value-前缀和为key的个数
        // 问题转化为和为 k 的问题
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            // 如果有与当前 sums[i] 差为 k 的则加上它的个数
            count += map.getOrDefault(sums[i] - k, 0);
            // 前缀和的个数
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return count;
    }
}