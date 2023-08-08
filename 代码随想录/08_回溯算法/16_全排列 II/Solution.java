import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/permutations-ii/
// 使用 nums[i] == nums[i - 1] 去重
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        dfs(new ArrayList<>(), new boolean[nums.length], 0);
        return res;
    }

    void dfs(List<Integer> path, boolean[] used, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;

            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(path, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

// 使用 tmpUsed 数组去重
class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), new boolean[nums.length], 0);
        return res;
    }

    void dfs(List<Integer> path, boolean[] used, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        boolean[] tmpUsed = new boolean[21];
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || tmpUsed[nums[i] + 10]) continue;
            path.add(nums[i]);
            used[i] = true;
            tmpUsed[nums[i] + 10] = true;
            dfs(path, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}