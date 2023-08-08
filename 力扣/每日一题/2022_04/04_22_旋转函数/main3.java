class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = 0;

        // 一次遍历，求出数组总和，与没有翻转情况下函数的初始值
        for(int i = 0; i < n; i++) {
            cur += nums[i] * i;
            sum += nums[i];
        }

        int res = cur;
        // 遍历每一次的翻转情况，自然先是从末端开始翻转
        for(int i = n - 1; i > 0; i --) {
            // 增加总和
            cur += sum;
            // 减去n份的末尾值
            cur -= nums[i] * n;
            // 求最大值
            res = Math.max(cur, res);
        }

        return res;
    }
}