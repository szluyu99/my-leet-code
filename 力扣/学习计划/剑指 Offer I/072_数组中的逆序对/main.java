/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 数组中的逆序对
 * 暴力（超时）
 */
class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j]) count++;
        return count;
    }
}