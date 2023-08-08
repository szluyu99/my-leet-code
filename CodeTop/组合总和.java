package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(new ArrayList<>(), 0, 0);
        return result;
    }

    void dfs(List<Integer> path, int start, int sum) {
        if (sum > target) return;

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, i, sum + nums[i]);
            path.remove(path.size() - 1); 
        }

    }
}