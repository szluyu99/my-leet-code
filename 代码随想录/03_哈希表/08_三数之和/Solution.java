import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] < -nums[i]) l++;
                else if (nums[l] + nums[r] > -nums[i]) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--; // 去重
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}