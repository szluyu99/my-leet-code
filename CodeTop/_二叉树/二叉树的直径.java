package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/diameter-of-binary-tree/
class Solution {
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root.left);
        return maxLen; 
    }

    // 寻找到 root 点的最长的路径（相当于找最大的深度的路径）
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 在这个过程中去计算二叉树中两个节点之间最长的路径长度
        maxLen = Math.max(maxLen, left + right);
        return Math.max(left, right) + 1; 
    }
}