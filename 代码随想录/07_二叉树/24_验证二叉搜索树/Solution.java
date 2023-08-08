import common.TreeNode;

// https://leetcode.cn/problems/validate-binary-search-tree/
// 中序 DFS
class Solution {
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

// 中序 DFS
class Solution1 {
    long preVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左
        if (!isValidBST(root.left)) return false;
        // 中
        if (root.val <= preVal) return false; 
        preVal = root.val; // 保存上一次遍历时的值
        // 右
        return isValidBST(root.right);
    }
}