import common.TreeNode;

// https://leetcode.cn/problems/trim-a-binary-search-tree/
// 模仿二叉搜索树的删除
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        // 不满足条件的叶子节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        // 当前节点的值不满足条件
        if (root.val < low || root.val > high) {
            // 度为 0 的节点 (叶子节点)：直接删除
            if (root.left == null && root.right == null) return null;
            // 度为 1 的节点: 返回不为空的节点
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // 度为 2 的节点: 
            else {
                // 找到前驱, 用前驱覆盖当前节点, 再删除前驱
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                root.val = pre.val;
                root.left = trimBST(root.left, low, high);
            }
        } 
        return root;
    }
}

// 递归
class Solution1 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        // root.val < low 则 root.left 下面的节点值都 < low
        if (root.val < low) return trimBST(root.right, low, high);
        // root.val > high 则 root.right 下面的值都 > high
        if (root.val > high) return trimBST(root.left, low, high);
        // 递归调用左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}