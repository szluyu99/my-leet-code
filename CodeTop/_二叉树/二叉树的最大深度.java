package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}