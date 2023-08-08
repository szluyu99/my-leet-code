import java.util.Arrays;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/submissions/
 * 递归
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 ) return null;

        int rootVal = preorder[0], rootIndex = 0;
        // 在[中序遍历]中寻找根节点的位置
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
            Arrays.copyOfRange(inorder, 0 , rootIndex)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length),
            Arrays.copyOfRange(inorder, rootIndex + 1, preorder.length)
        );
        return root;
    }
}
