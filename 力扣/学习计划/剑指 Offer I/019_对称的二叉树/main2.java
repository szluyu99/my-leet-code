class Solution {
    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) return true;
        return isMirror(root.left, root.right);
    }
    /**
     * 判断传入的两颗树是否镜像
     */
    boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}