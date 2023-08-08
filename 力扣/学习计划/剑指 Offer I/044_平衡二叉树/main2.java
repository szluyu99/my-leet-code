import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

/**
 * 利用 map 优化递归中的重复计算（但是为什么速度更慢了。。。）
 */
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int maxDepth(TreeNode node) {
        if (node == null) return 0;

        if (map.containsKey(node))
            return map.get(node);

        int curDepth = Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        map.put(node, curDepth);
        return curDepth;
    }
}
