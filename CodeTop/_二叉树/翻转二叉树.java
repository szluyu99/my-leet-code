package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/invert-binary-tree/
class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}