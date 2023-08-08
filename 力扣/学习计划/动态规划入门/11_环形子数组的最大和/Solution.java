import java.util.Arrays;

// 分情况讨论循环与不循环
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 情况一：循环, 数组和 - 最小子数组和
        int max1 = sum - minSubarray(nums);
        // 情况二：未循环, 最大子数组和
        int max2 = maxSubarray(nums);
        // max1 == 0 说明整个数组都是负数
        return max1 == 0 ? max2 : Math.max(max1, max2);
    }

    // 最小子数组和
    int minSubarray(int[] nums) {
        int cur = nums[0], min = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.min(cur + nums[i], nums[i]);
            min = Math.min(min, cur);
        }
        return min;
    }
    
    // 最大子数组和
    int maxSubarray(int[] nums) {
        int cur = nums[0], max = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}

// 优化成一轮循环
class Solution1 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0]; // 数组和
        int minDp = nums[0], min = minDp; // 求子数组的最小和
        int maxDp = nums[0], max = maxDp; // 求子数组的最大和
        for (int i = 1; i < nums.length; i++) {
            // 求子数组的最小和
            minDp = Math.min(minDp + nums[i], nums[i]);
            min = Math.min(min, minDp);
            // 求子数组的最大和
            maxDp = Math.max(maxDp + nums[i], nums[i]);
            max = Math.max(max, maxDp);
            // 求子数组的和
            sum += nums[i];
        }

        // 情况一：经历循环, 最大和 = 数组和 - 最小子数组和
        int max1 = sum - min;
        // 情况二：未经历循环, 最大和 = 最大子数组和
        int max2 = max;

        // max1 == 0 说明整个数组都是负数
        return max1 == 0 ? max2 : Math.max(max1, max2);
    }

}