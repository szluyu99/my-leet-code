package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), 0); 
        return result;
    }

    void dfs(List<Integer> path, int start) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}