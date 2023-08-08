package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/permutations-ii/
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] == nums[i - 1] && visited[i - 1])) continue;
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}