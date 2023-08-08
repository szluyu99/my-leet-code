import common.TreeNode;

// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
// 中序 DFS
class Solution {
    int res = Integer.MAX_VALUE;
    int prev = -100010; // 记录上一个节点的值
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        res = Math.min(res, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }
}