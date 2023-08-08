import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<Integer> path, int start) {
        res.add(new ArrayList<>(path)); // 每次都将结果添加进来

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}