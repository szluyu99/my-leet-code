package CodeTop._深搜回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-ii/
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    void dfs(int[] arr, int target, List<Integer> path, int start, int sum) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            path.add(arr[i]);
            dfs(arr, target, path, i + 1, sum + arr[i]);
            path.remove(path.size() - 1);
        }
    }
}