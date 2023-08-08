package CodeTop._二叉树;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
// 中序遍历
class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(list.size() - k);
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}

// 倒着中序遍历
class Solution1 {
    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node == null || k == 0) return;
        dfs(node.right);
        if (--k == 0) result = node.val;
        dfs(node.left);
    }
}