import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
class Solution {
    /**
     * 双重递归
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    boolean helper(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
