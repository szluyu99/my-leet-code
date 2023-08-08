import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
// 递归
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// DFS
class Solution1 {
    int maxLevel = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxLevel;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > maxLevel) maxLevel = level;
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

// BFS
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int cnt = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            cnt ++ ;
        }
        return cnt;
    }
}
