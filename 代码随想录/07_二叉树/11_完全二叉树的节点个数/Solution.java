import java.util.LinkedList;
import java.util.Queue;
import common.TreeNode;

// https://leetcode.cn/problems/count-complete-tree-nodes/
// 利用完全二叉树的特性
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left); // 左子树的高度
        int r = getHeight(root.right); // 右子树的高度
        if (l == r) {
            // 左右子树高度相等，表示左子树一定是满二叉树
            // 用公式计算左子树的节点个数：2^l - 1
            // 递归计算右子树的节点个数 countNodes(root.right)
            // 再 + 1 (当前节点)
            return countNodes(root.right) + (1 << l); // 1 << l == 2^l
        } else {
            // 最后一层不满，但是倒数第二层是满的，右子树一定是满二叉树
            // 公式计算右子树的节点个数: 2^r - 1
            // 递归计算左子树的节点个数 countNodes(root.left)
            // 再 + 1 (当前节点)
            return countNodes(root.left) + (1 << r); // 1 << r == 2^r
        }
    }

    // 完全二叉树计算高度
    int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}

// 递归
class Solution1 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// DFS
class Solution2 {
    int num = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return num;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        num++;
        dfs(node.left);
        dfs(node.right);
    }
}

// 层序遍历
class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
            count++;
        }
        return count;
    }
}