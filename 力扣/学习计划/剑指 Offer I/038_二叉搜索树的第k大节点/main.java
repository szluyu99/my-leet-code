import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/submissions/
/**
 * 遍历 + 排序
 */
class Solution {

    List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(list, (c1, c2) -> c1 - c2);
        return list.get(k - 1);
    }

    void dfs(TreeNode node) {
        if (node == null)
            return;
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}