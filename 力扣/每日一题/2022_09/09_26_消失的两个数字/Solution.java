import java.util.Arrays;

// https://leetcode.cn/problems/missing-two-lcci/
// 排序 - 时间O(nlogn)
class Solution {
    public int[] missingTwo(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];

        for (int i = 1, j = 0, idx = 0; i <= nums.length + 2; i++) {
            if (j < nums.length && nums[j] != i || j >= nums.length) {
                res[idx++] = i;
            } else j++;
            if (idx == 2) return res;
        }
        return res;
    }
}

// 时间O(n) 空间O(1)
class Solution1 {
    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];

        int[] count = new int[nums.length + 3];
        for (int n : nums) count[n]++;

        for (int i = 1, idx = 0; i <= nums.length + 2; i++) {
            if (count[i] == 0) res[idx++] = i;
            if (idx == 2) return res;
        }
        // 如果从头到尾都没有找到数字，那么这两个数字是最后两个数字
        if (res[0] == 0) return new int[] { nums.length + 1, nums.length + 2 };
        return res;
    }
}
