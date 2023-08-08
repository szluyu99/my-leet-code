import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int [] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(this.candidates); // 剪枝的前提
        dfs(new ArrayList<>(), 0, 0);
        return res;
    }

    void dfs(List<Integer> path, int sum, int start) {
        // if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：下一层的 sum 会大于 target，则不用进行后续递归
            if (sum + candidates[i] > target) break;
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(path, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}