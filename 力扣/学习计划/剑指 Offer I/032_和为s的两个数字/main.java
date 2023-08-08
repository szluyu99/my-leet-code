import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
class Solution {
    /**
     * 遍历时将数据存到set中，判断 tartget-nums[i] 是否在set中存在
     */
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i]))
                return new int[] { nums[i], target - nums[i] };
            set.add(nums[i]);
        }
        return null;
    }

    /**
     * set 优化循环开始位置
     */
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int mid = nums.length / 2;
        int start = 0;
        if (nums[mid] > target)
            start = mid;
        for (int i = start; i < nums.length; i++) {
            if (set.contains(target - nums[i]))
                return new int[] { nums[i], target - nums[i] };
            set.add(nums[i]);
        }
        return null;
    }

    /**
     * 双指针
     */
    public int[] twoSum2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int num = nums[l] + nums[r];
            if (num < target)
                l++;
            else if (num > target)
                r--;
            else
                return new int[] { nums[l], nums[r] };
        }
        return null;
    }
}