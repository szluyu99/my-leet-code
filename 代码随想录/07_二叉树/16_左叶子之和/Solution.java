import common.TreeNode;

// https://leetcode.cn/problems/sum-of-left-leaves/
// DFS
class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        dfs(root, null);
        return res;
    }
    // DFS 时传入 parent 节点用来判断是否是左叶子
    void dfs(TreeNode node, TreeNode parent) {
        if (node == null) return;
        // 判断是左叶子
        if (node.left == null && node.right == null && parent.left == node)
            res += node.val;
        dfs(node.left, node);
        dfs(node.right, node);
    }
}

// 递归
class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            res += root.left.val;
        return  sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }
}
