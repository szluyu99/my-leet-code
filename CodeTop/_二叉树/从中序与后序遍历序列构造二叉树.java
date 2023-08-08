package CodeTop._二叉树;

import java.util.Arrays;

import common.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder - 左根右     [9] [3] [15, 20, 7] -> [15] [20] [7]
        // postorder - 左右根   [9] [15, 7, 20] [3] -> [15] [7] [20]
        if (inorder.length == 0) return null;
        // 初始化根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        // 在 inorder[] 中找到根的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(
                    Arrays.copyOfRange(inorder, 0, i),
                    Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(
                    Arrays.copyOfRange(inorder, i + 1, inorder.length),
                    Arrays.copyOfRange(postorder, i, postorder.length - 1));
                break;
            }
        }
        return root;
    }
}