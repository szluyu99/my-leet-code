import common.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
// 递归
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // root 左右两边都能找到
        if (left != null && right != null) return root;
        // 只有 root 左边能找到
        if (left != null) return left;
        // 只有 root 右边能找到
        if (right != null) return right;
        // 左右都找不到
        return null;
    }
}