package CodeTop._二叉树;

import common.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
class Solution {
    int idx = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k); 
        return result;
    }

    void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        idx++;
        if (idx == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
}