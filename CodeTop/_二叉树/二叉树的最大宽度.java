package CodeTop._二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/maximum-width-of-binary-tree/
// BFS
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        root.val = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int width = q.getLast().val - q.getFirst().val + 1;
            for (int i = q.size() - 1; i >= 0; i--) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    q.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    q.add(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}

// DFS
class Solution1 {
    int maxWidth = 1;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0, new ArrayList<>());
        return maxWidth;
    }

    // 通过 DFS 找出最大宽度
    // 保存每层的左端点的索引, 每次用当前节点的索引减其最左端点的索引, 算出宽度
    private void dfs(TreeNode root, int level, int index, List<Integer> left) {
        if (root == null) return;

        if (level >= left.size()) left.add(index);
        else maxWidth = Math.max(maxWidth, index - left.get(level) + 1);

        dfs(root.left, level + 1, index * 2, left);
        dfs(root.right, level + 1, index * 2 + 1, left);
    }
}