import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited);
        return res;
    }

    void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 标记已访问
            visited[i] = true;
            path.add(nums[i]);
            // 继续搜索
            dfs(nums, path, visited);
            // 回溯
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}