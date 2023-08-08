import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/combinations/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(new ArrayList<>(), 1);
        return res;
    }

    void dfs(List<Integer> path, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(path, i + 1);
            path.remove(path.size() - 1); // 回溯
        }
    }
}