import java.util.Arrays;

import common.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder = [3,9,20,15,7] -> [3] [9] [20, 15, 7] 根左右
        // inorder = [9,3,15,20,7] -> [9] [3] [15, 20, 7] 左根右
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(
                    Arrays.copyOfRange(preorder, 1, i + 1),
                    Arrays.copyOfRange(inorder, 0, i)
                );
                root.right = buildTree(
                    Arrays.copyOfRange(preorder, i + 1, preorder.length),
                    Arrays.copyOfRange(inorder, i + 1, inorder.length)
                );
                break;
            }
        }
        return root;
    }
}