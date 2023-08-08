import common.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 如果 p, q 中有等于 root 的，那么它们的最近公共祖先为该节点
        if (root == p || root == q) return root;
        // 往左找公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 往右找公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左边找不到, 则一定在右边
        if (left == null) return right;
        // 右边找不到, 则一定在左边
        if (right == null) return left;
        // 左右都找不到, 则当前 root 为最近公共祖先
        return root;
    }
}