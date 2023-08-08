import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-iii/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int k, n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(new ArrayList<>(), 0, 1); 
        return res;
    }

    void dfs(List<Integer> path, int sum, int u) {
        if (sum > n) return; // 剪枝
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = u; i <= 9; i++) {
            sum += i;
            path.add(i);
            dfs(path, sum, i + 1); 
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}