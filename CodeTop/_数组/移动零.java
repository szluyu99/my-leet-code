package CodeTop._数组;

// https://leetcode.cn/problems/move-zeroes/
// 遍历数组, 遇到 0 时向后找到第一个非 0 值交换
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0)
                    j++;
                if (j < nums.length && nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}

// 双指针 l = 0, r = 0, r 往后走遇到非 0 元素和 l 交换
class Solution1 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                l++;
            }
        }
    }
}

// 将所有非 0 元素按顺序放前面, 后面元素全部赋 0 
class Solution2 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        // 将非 0 元素按顺序放到前面
        for (int r = 0; r < nums.length; r++)
            if (nums[r] != 0) nums[l++] = nums[r];
        // 后面全部赋 0
        while (l < nums.length) nums[l++] = 0;
    }
}