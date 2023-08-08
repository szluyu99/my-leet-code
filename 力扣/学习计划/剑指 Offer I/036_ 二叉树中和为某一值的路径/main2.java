import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

/**
 * 题解
 */
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> visited = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    void dfs(TreeNode node, int target) {
        if (node == null) return;

        visited.add(node.val);
        target -= node.val;
	
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new LinkedList<>(visited));
        }

        dfs(node.left, target);
        dfs(node.right, target);

        // 回溯
        visited.removeLast();
    }
}
