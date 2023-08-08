// https://leetcode.cn/problems/squares-of-a-sorted-array/
// 双指针
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[l] + nums[r] < 0) { // 左边绝对值大
                res[i] = nums[l] * nums[l++];
            } else { // 右边绝对值大
                res[i] = nums[r] * nums[r--];
            }
        }
        return res;
    }
}