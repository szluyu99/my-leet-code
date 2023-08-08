import common.TreeNode;

// https://leetcode.cn/problems/delete-node-in-a-bst/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // 目标值 < 当前节点值, 往左找
        if (root.val > key) root.left = deleteNode(root.left, key);
        // 目标值 > 当前节点值, 往右找
        else if (root.val < key) root.right = deleteNode(root.right, key);
        // 目标值 == 当前节点值, 进行删除操作
        else {
            // 情况 1: 度为 0 的节点 (叶子节点): 直接删除
            if (root.left == null && root.right == null) return null;
            // 情况 2: 度为 1 的节点: 用子节点替代该节点
            else if (root.right == null) return root.left;
            else if (root.left == null) return root.right;
            // 情况 3: 度为 2 的节点: 用 前驱/后继 覆盖它, 再删除 前驱/后继
            else {
                // 前驱: 比自己小的最大节点 -> 左节点的最右节点
                // TreeNode pre = root.left;
                // while (pre.right != null) pre = pre.right; // 寻找前驱
                // root.val = pre.val; // 用前驱覆盖当前节点
                // root.left = deleteNode(root.left, pre.val); // 删除前驱
                
                // 后继: 比自己大的最小节点 -> 右节点的最左节点
                TreeNode suc = root.right;
                while (suc.left != null) suc = suc.left; // 寻找后继
                root.val = suc.val; // 用后继覆盖当前节点
                root.right = deleteNode(root.right, suc.val); // 删除后继
            }
        }
        return root;
    }
}