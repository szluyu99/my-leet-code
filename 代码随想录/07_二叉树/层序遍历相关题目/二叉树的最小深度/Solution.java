import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
// 层序遍历
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }
        return level;
    }
}

// DFS
class Solution1 {
    int minLevel = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return minLevel;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            minLevel = Math.min(minLevel, level);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

// 递归
class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 处理只有一个子节点的情况
        if (root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        if (root.right == null && root.left != null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}