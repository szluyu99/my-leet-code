package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/balanced-binary-tree/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean flag = Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
        return flag && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}