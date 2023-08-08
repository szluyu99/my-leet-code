package 力扣.比赛.LCCUP22_战队赛;

import common.TreeNode;

class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) return null;
        // if (root.val == -1) return 
        TreeNode head = root;

        if (root.left != null) {
            TreeNode tmp = root.left;
            root.left = new TreeNode(-1);
            root.left.left = tmp;
        }
        if (root.right != null) {
            TreeNode tmp = root.right;
            root.right = new TreeNode(-1);
            root.right.right = tmp;
        }

        if (root.left != null && root.left.val == -1) {
            root.left.left =  expandBinaryTree(root.left.left);
        }
        if (root.right != null && root.right.val == -1) {
            root.right.right = expandBinaryTree(root.right.right);
        }

        return head;
    }
}