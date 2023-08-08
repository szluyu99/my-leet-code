import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/binary-tree-right-side-view/
// 层次遍历，每次只添加最后一个元素
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (i == 1) res.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}

// dfs 将第一次访问该深度的右边元素添加到结果中
class Solution1 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) return;
        // 第一次访问这个深度
        if (depth == res.size()) res.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}