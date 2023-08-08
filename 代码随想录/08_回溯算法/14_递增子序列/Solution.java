import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/increasing-subsequences/

// 维护一个哈希表来判断是否出现过重复元素
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<Integer> path, int start) {
        if (path.size() >= 2) res.add(new ArrayList<>(path));
        // 每层的新建一个哈希表用于去重
        boolean[] used = new boolean[201]; // 标记已经使用过
        for (int i = start; i < nums.length; i++) {
            // 必须满足递增的条件
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)
                    || used[nums[i] + 100]) continue;
            used[nums[i] + 100] = true; // 标记已经使用
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

// res.add(path) 前去重，会超时
class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    void dfs(List<Integer> path, int start) {
        if (path.size() >= 2) {
            for (var ll : res)
                if (ll.equals(path)) return;
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            if (i >= 1 && nums[i] < nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}