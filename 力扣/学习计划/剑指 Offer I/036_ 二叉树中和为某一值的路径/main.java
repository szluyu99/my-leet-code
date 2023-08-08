import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/comments/
 * DFS + 回溯
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, 0, new ArrayList<>(), target);
        return res;
    }

    void dfs(TreeNode node, int sum, List<Integer> visited, int target) {
        if (node == null) return;

        sum += node.val;
        visited.add(node.val);

      	// 注意题目要求必须是叶子节点 
        if (target == sum && node.left == null && node.right == null) {
          	// 不 new 则存到 res 中的 visited 也会跟着改
            res.add(new ArrayList<>(visited));
        }

        // 向左搜索
        dfs(node.left, sum, visited, target);
        // 向右搜索
        dfs(node.right, sum, visited, target);

        // 回溯
        visited.remove(visited.size() - 1);
        sum -= node.val;
    }

}