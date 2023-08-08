import common.TreeNode;

/**
 * DFS + 剪枝
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    /**
     * 计算树的深度 + 剪枝
     * 当有左右子树高度差 >= 2 的情况
     * 直接返回 -1 表示不平衡
     */
    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        if (left == -1) return -1; // 剪枝
        int right = dfs(node.right);
        if (right == -1) return -1; // 剪枝
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}