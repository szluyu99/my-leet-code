import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 最小的数 > 0 或 最大的数 < 0, 不可能和为 0
        if (nums[0] > 0 || nums[n - 1] < 0) return res;
        
        for (int i = 0; i < n; i++) {
             if (nums[i] > 0) break; // 不可能找到和为 0 的三元组
             if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
             // 转化成两数之和: 寻找 nums[j] + nums[k] = -nums[i]
             // 两数之和寻找方法: 双指针, j 从前开始, k 从后开始
             int j = i + 1, k = n - 1, target = -nums[i];
             while (j < k) {
                if (nums[j] + nums[k] < target) j++;
                else if (nums[j] + nums[k] > target) k--;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++; // 去重
                    while (j < k && nums[k] == nums[k - 1]) k--; // 去重
                    j++;
                    k--;
                }
             }
        }
        return res;
    }
}