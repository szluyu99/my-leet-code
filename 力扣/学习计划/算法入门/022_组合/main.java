import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int k, n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        dfs(1, new ArrayList<>());
        return res;
    }

    /**
     * 
     * @param begin 开始搜索的数字
     * @param path  已经访问过的路径
     */
    void dfs(int begin, List<Integer> path) {
        // 剪枝: 当前访问过 path 长度 + [begin, n] 的长度 < k
        // 不可能走到长度为 k 的 path
        if (path.size() + (n - begin + 1) < k) return;
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(i + 1, path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}