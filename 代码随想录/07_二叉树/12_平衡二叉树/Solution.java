import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/balanced-binary-tree/
// 递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right); 
    }
    int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        return Math.max(leftH, rightH) + 1;
    }
}

// 带剪枝的递归
class Solution1 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left); // 左子树高度
        int rightH = getHeight(node.right); // 右子树高度
        // 剪枝：左子树 或 右子树 不满足条件 或 当前节点不满足条件，直接返回 -1
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;
        // 左右子树都满足条件，返回当前节点的高度
        return Math.max(leftH, rightH) + 1;
    }
}

// 层序遍历
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) return false;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return true;
    }
    int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
