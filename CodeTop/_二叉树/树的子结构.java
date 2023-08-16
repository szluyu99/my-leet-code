package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val) {
            if (dfs(A.left, B.left) && dfs(A.right, B.right)) {
                return true;
            }
        }
        return false;
    }
}