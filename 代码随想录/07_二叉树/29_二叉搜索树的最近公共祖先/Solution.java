import common.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 递归
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 p, q 值都小于 root, 说明 p, q 在 root 的左子树中
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        // 如果 p, q 值都大于 root, 说明 p, q 在 root 的右子树中
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        // p, q 分布在 root 左右，则 root 为最近公共祖先
        return root;
    }
}

// 迭代
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
        return null;
    }
}