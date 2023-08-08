import common.TreeNode;

/**
 * 倒中序遍历
 */
class Solution {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return res;
    }

    void helper(TreeNode node) {
        if (node == null) return;
        helper(node.right);
        if (--k == 0) { 
            res = node.val;
            return;
        }
        helper(node.left);
    }
}
