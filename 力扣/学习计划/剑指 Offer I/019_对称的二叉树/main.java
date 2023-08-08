import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
class Solution {
    /**
     * 暴力
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode newTree = mirrorTree(root);
        return isSame(root, newTree);
    }

    /**
     * 判断两棵二叉树是否相同
     */
    boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        } else return false;
    }
    /**
     * 获得二叉树的镜像
     */
    TreeNode mirrorTree(TreeNode root) {
        if (root == null)  return null;
        TreeNode leftNode = mirrorTree(root.left);
        TreeNode rightNode = mirrorTree(root.right);
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = rightNode;
        newTree.right  = leftNode;
        return newTree;
    }
}

