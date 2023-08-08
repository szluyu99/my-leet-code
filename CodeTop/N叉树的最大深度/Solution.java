package CodeTop.N叉树的最大深度;

import java.util.LinkedList;
import java.util.Queue;

import common.Node;

// https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/

// 递归
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;
        int max = Integer.MIN_VALUE;
        for (Node node : root.children)
            max = Math.max(max, maxDepth(node));
        return max + 1;
    }
}

// BFS
class Solution1 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                for (Node n : node.children) q.add(n);
            }
            level++;
        }
        return level;
    }
}

