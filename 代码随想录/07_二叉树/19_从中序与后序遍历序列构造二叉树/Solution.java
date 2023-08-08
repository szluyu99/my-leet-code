import java.util.Arrays;

import common.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// 递归 - 传入索引进行优化
class Solution {
    int[] inorder_map = new int[6001]; // 数组模拟哈希
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        // 下标映射
        for (int i = 0; i < inorder.length; i++) 
            inorder_map[inorder[i] + 3000] = i;
        return help(inorder, 0, inorder.length - 1, 
                      postorder, 0, postorder.length - 1);
    }

    // inorder [s1, e1] postorder [s2, e2]
    TreeNode help(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        int rootVal = postorder[e2]; // 根节点的值
        TreeNode root = new TreeNode(rootVal); // 初始化根节点
        int rootValIdx = inorder_map[rootVal + 3000]; // 中序遍历中根节点值的下标
        // 左子树长度 = rootValIx - s1 -1
        // s2 + rootValIdx - s1 - 1 表示计算 后序数组 的结束位置,
        root.left = help(inorder, s1, rootValIdx - 1,
                         postorder, s2, s2 + rootValIdx - s1 - 1);
        root.right = help(inorder, rootValIdx + 1, e1,
                          postorder, s2 + rootValIdx - s1, e2 - 1);
        return root;
    }
}

// 递归 - 初始
class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder - 左根右     [9] [3] [15, 20, 7] 
        // postorder - 左右根   [9] [15, 7, 20] [3] 
        // 递归处理, 传入 inorder = [15, 20, 7], postorder = [15, 7, 20]
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);

        int rootVal = postorder[postorder.length - 1]; // 根节点的值
        TreeNode root = new TreeNode(rootVal);
        int rootValIdx = 0;
        // 在 inorder[] 中找到根的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootValIdx = i;
                break;
            }
        }
        root.left = buildTree(
            Arrays.copyOfRange(inorder, 0, rootValIdx),
            Arrays.copyOfRange(postorder, 0, rootValIdx)
        );
        root.right = buildTree(
            Arrays.copyOfRange(inorder, rootValIdx + 1, inorder.length),
            Arrays.copyOfRange(postorder, rootValIdx, postorder.length - 1)
        );
        return root;
    }
}

// 递归 - 精简代码
class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
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