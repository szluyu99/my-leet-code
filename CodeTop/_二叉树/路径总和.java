package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/path-sum/
class Solution {
    boolean result = false;
    int targetSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode root, int sum) {
        if (result || root == null) return;

        if (root.left == null && root.right == null) {
            if (root.val + sum == targetSum) {
                result = true;
            }
        }

        dfs(root.left, sum + root.val);
        dfs(root.right, sum + root.val);
    }
}