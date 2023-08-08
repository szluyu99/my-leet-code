package CodeTop._二叉树;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/path-sum-ii/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int targetSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, new ArrayList<>(), 0);
        return result;
    }

    void dfs(TreeNode root, List<Integer> path, int sum) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        
        dfs(root.left, path, sum + root.val);
        dfs(root.right, path, sum + root.val);
        path.remove(path.size() - 1);
    }
}