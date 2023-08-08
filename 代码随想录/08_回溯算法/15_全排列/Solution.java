import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/permutations/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums; 

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), new boolean[nums.length], 0);
        return res;
    }

    void dfs(List<Integer> path, boolean[] used, int u) {
        if (u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(path, used, u + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}