import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 462. 最少移动次数使数组元素相等 II
 */
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j)
            res += nums[j--] - nums[i++];
        return res;
    }
}
