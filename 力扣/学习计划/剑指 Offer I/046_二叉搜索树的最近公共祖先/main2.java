import common.TreeNode;

class Solution {
    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归出口，此题可以不判断，因为题目保证有解

        // p, q 都 < root, 说明公共祖先一定在 root 左边，往左找
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        // p, q 都 > root, 说明公共祖先一定在 root 右边，往右找
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        // p, q 分别在 root 的左右，则为公共祖先
        return root;
    }
}