import common.TreeNode;

// https://leetcode.cn/problems/search-in-a-binary-search-tree/
// 递归
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return root;
    }
}
// 迭代
class Solution1 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val < val) root = root.right;
            else if (root.val > val) root = root.left;
            else return root;
        }
        return null;
    }
}