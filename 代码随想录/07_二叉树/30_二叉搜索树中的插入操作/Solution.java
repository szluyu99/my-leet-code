import common.TreeNode;

// https://leetcode.cn/problems/insert-into-a-binary-search-tree/
// 递归
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}

// 迭代
class Solution1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root, parent = root; // 记录上一个节点
        while (node != null) {
            parent = node;
            if (val > node.val) node = node.right;
            else node = node.left;
        }
        if (val > parent.val) parent.right = new TreeNode(val); 
        else parent.left = new TreeNode(val);
        return root;
    }
}