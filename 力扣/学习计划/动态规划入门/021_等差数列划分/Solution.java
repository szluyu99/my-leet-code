// https://leetcode-cn.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        // dp[i] 以 i 结尾的子数组为等差数列的个数
        int[] dp = new int[nums.length];
        // 初始化 DP 数组
        dp[2] = isArithmeticSequence(nums, 2) ? 1 : 0;
    
        int res = dp[2];
        for (int i = 3; i < nums.length; i++) {
            if (dp[i - 1] == 0) {
                // 前一个元素结尾不构成等差数列, 则当前元素结尾如果能构成等差数列只有 1
                dp[i] = isArithmeticSequence(nums, i) ? 1 : 0;
            } else {
                // 前一个元素结尾能构成等差数列, 则当前元素如果能构成等差数列为前面的数量 + 1
                dp[i] = isArithmeticSequence(nums, i) ? dp[i - 1] + 1 : 0;
            }
            // 计算每个元素结尾构成的等差数列的和
            res += dp[i];
        }
        return res;
    }   
    // 判断数组 i, i-1, i-2 元素是否是等差数列
    boolean isArithmeticSequence(int[] nums, int i) {
        return nums[i] + nums[i - 2] == 2 * nums[i - 1];
    }
}