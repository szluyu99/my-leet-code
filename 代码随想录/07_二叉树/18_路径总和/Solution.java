import common.TreeNode;

// https://leetcode.cn/problems/path-sum/
// DFS
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null && sum + node.val == targetSum)
            return true;
        return dfs(node.left, node.val + sum, targetSum)
                || dfs(node.right, node.val + sum, targetSum);
    }
}

// DFS: 使用 - 优化掉传递的参数
class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}