package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return maxSum;
    }

    // 以 root 节点为起始的最大路径和
    int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}