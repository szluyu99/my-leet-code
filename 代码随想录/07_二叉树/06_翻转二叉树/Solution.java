import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/invert-binary-tree/
// 递归
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 交换左右子节点
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// 层序遍历
class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 交换子树
            TreeNode t = node.right;
            node.right = node.left;
            node.left = t;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
 
// DFS
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode t = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = t;
        return root;
    }
}
