package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;

        return null;    
    }
}
