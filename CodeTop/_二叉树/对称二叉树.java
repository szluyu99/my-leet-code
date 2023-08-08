package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/symmetric-tree/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    // 检查两个节点是否对称
    public boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null || n1.val != n2.val) return false;
        return helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }
}