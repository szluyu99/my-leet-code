import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

// https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
