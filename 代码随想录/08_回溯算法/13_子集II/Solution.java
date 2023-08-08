import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/subsets-ii/

// 回溯 + 不添加重复元素
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 检查元素重复的前提
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 不添加重复元素
            if (i != start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

// 回溯 + 添加前检查是否元素重复
class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 必须
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<Integer> path, int start) {
        // 防止添加重复元素
        for (List<Integer> l : res)
            if (l.equals(path)) return;
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}