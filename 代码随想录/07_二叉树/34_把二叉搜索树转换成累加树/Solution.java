import common.TreeNode;

// https://leetcode.cn/problems/convert-bst-to-greater-tree/
// 递归 - 右左根 顺序 + 累加和
class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        root.right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);        
        return root;
    }
}