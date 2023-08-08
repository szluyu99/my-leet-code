// https://leetcode.cn/problems/maximum-swap/
// 暴力
class Solution {
    public int maximumSwap(int num) {
        int[] nums = numToArray(num);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                swap(nums, i, j); // 交换 i, j 位置
                max = Math.max(max, arrayToNum(nums));
                swap(nums, i, j); // 还原 nums 数组
            }
        }
        return max;
    }

    // 数字转数组: 2736 -> [2,7,3,6]
    int[] numToArray(int num) {
        int n = 0;
        int tmp = num;
        while (tmp > 0) {
            tmp /= 10;
            n++;
        }
        int[] nums = new int[n];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }
        return nums;
    }

    // 数组转数字: [7,2,3,6] -> 7236
    int arrayToNum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res = res * 10 + nums[i];
        return res;
    }

    // 交换数组元素
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

// 贪心: 右边越大的数字与左边较小的数字进行交换，这样产生的整数才能保证越大
class Solution1 {
    public int maximumSwap(int num) {
        int[] index = new int[10];
        char[] n = String.valueOf(num).toCharArray();

        // 预处理出每个数字最后一次出现的下标
        for (int i = 0; i < n.length; i++)
            index[n[i] - '0'] = i;

        // 将大的数字放到左边
        for (int i = 0; i < n.length; i++) {
            // 从大的数字开始枚举
            for (int j = 9; j > n[i] - '0'; j--) { // 要求数字比当前数字大
                if (index[j] > i) { // 要求下标在当前的右边
                    swap(n, i, index[j]);
                    return Integer.valueOf(String.valueOf(n));
                }
            }
        }
        return num;
    }

    void swap(char[] num, int i, int j) {
        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}