package CodeTop._数组;

// https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) result[l++] = nums[i];
            else result[r--] = nums[i];
        }
        return result;
    }
}


// 原地交换
class Solution1 {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && (nums[l] % 2) == 1) l++; // 奇
            while (l < r && (nums[r] % 2) == 0) r--; // 偶
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}