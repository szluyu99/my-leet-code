import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/successor-lcci/
 * 后继者
 */
class Solution {
    // dfs 暴力
    List<TreeNode> list = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        Collections.sort(list, (o1, o2) -> o1.val - o2.val);
        int idx = list.indexOf(p);
        return idx < list.size() - 2 ? list.get(idx + 1) : null;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    // 递归
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        // 当前节点值小于等于目标值，那么当前目标值的后继者必然在右子树
        if (p.val >= root.val)
            return inorderSuccessor(root.right, p);
        // 否则结果有可能是当前节点，或者在当前节点的左子树中
        // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}
