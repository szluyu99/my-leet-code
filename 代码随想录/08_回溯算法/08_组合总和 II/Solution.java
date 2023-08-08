import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-ii/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        dfs(new ArrayList<>(), 0, 0);
        return res;
    }

    void dfs(List<Integer> path, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 去重
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(path, sum, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1); 
        }
    }
}