package CodeTop.另一棵树的子树;

import common.TreeNode;

// https://leetcode.cn/problems/subtree-of-another-tree/
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // 判断 n1 和 n2 是否是相同的树
    boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null || n1.val != n2.val) return false;
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
