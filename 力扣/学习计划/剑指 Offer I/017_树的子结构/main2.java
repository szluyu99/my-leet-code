import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

class Solution {
    /**
     * BFS
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Queue<TreeNode> queue = new LinkedList<>() {{ offer(A); }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == B.val) 
                if (helper(node, B))
                    return true;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return false;
    }
    boolean helper(TreeNode A, TreeNode B) {
        Queue<TreeNode> queueA = new LinkedList<>() {{ offer(A); }};
        Queue<TreeNode> queueB = new LinkedList<>() {{ offer(B); }};

        while (!queueB.isEmpty()) {
            TreeNode nodeA = queueA.poll();
            TreeNode nodeB = queueB.poll();
            if (nodeA == null || nodeA.val != nodeB.val)
                return false;
            if (nodeB.left != null) {
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.left);
            }
            if (nodeB.right != null) {
                queueA.offer(nodeA.right);
                queueB.offer(nodeB.right);
            }
        }
        return true;
    }
}
