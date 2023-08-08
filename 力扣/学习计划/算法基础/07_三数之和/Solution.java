import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i]; // 三数之和
                if (sum > 0) r--; // > 0 减小右边的数
                else if (sum < 0) l++; // < 0 增大左边的数
                else { // 找到了三数之和为 0 的三元组
                    res.add(List.of(nums[l], nums[r], nums[i]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--; 
                }
            }
        }
        return res;
    }
}