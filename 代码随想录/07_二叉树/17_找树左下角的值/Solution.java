import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/find-bottom-left-tree-value/
// 层序遍历1
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (i == size) res = node.val; // 每次更新为当前层第一个节点的值
            }
        } 
        return res;
    }
}

// 层序遍历2
class Solution1 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) q.offer(root.right);
            if (root.left != null) q.offer(root.left);
        } 
        return root.val;
    }
}

// DFS：遍历同时求出树的深度
class Solution2 {
    int maxLevel = Integer.MIN_VALUE;
    int res;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);     
        return res;
    }
    
    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            if (level > maxLevel) {
                maxLevel = level;
                res = node.val;
            }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1); 
    }
}
