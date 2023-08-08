import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
class Solution {
    /**
     * DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
    /**
     * BFS
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>() {{ offer(root); }};
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return res;
    }
}

