import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.Node;

// https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                tmpList.add(node.val);
                for (Node n : node.children) q.add(n);
            }
            res.add(tmpList);
        }
        return res;
    }
}