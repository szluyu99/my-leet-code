package CodeTop._二叉树;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/

// 直接递归
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null) {
            TreeNode node = root.left;
            if (node.val >= root.val)
                return false;
            while (node.right != null)
                node = node.right;
            if (node.val >= root.val)
                return false;
        }
        if (root.right != null) {
            TreeNode node = root.right;
            if (node.val <= root.val)
                return false;
            while (node.left != null)
                node = node.left;
            if (node.val <= root.val)
                return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}

// 中序遍历途中判断是否有序
class Solution1 {
    boolean res = true;
    long preVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }
    
     void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (node.val <= preVal) res = false;
        preVal = node.val; // 保存上一次遍历时的值
        dfs(node.right);
    }
}

// 中序遍历完再判断是否有序
class Solution2 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val); 
        inorder(root.right);
    }
}


