import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/submissions/
 * DFS + maxDepth
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
