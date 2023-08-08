import java.util.Arrays;

class Solution {
    static int maxValue(int[] nums, int[] w, int[] v, int c) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < w.length; i++) // 物品
            for (int j = c; j >= w[i]; j--) { // 背包容量
                for (int k = 1; k <= nums[i] && k * w[i] <= j; k++) // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * w[i]] + k * v[i]);
                System.out.println(Arrays.toString(dp));
            }
        return dp[c];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 2 };
        int[] w = new int[] { 1, 3, 4 }; // 重量
        int[] v = new int[] { 15, 20, 30 }; // 价值
        int c = 10; // 背包容量

        System.out.println(maxValue(nums, w, v, c));
    }
}
