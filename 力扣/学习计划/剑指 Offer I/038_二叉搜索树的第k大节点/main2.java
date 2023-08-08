import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * 中序遍历一次，计算树的节点个数
 */
class Solution {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(list.size() - k);
    }

    void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
