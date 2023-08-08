import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/4sum/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;
        Arrays.sort(nums);
        if (nums[0] > 0 && target <= 0 || nums[n - 1] < 0 && target >= 0) return res;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            // 剪枝: 当前情况的最小和 > target 或 最大和 < target
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 去重
                // 剪枝: 当前情况的最小和 > target 或 最大和 < target
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
                // 两数之和
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) k++;
                    else if (sum > target) l--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) k++; // 去重
                        while (k < l && nums[l] == nums[l - 1]) l--; // 去重
                        k++;
                        l--;
                    }
                }
            }
        }
        return res;
    }
}