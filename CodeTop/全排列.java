package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/permutations/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            path.add(nums[i]);

            dfs(nums, path, visited);

            visited[i] = false;
            path.remove(path.size() - 1);
        }

    }
}