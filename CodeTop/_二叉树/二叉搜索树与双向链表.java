package CodeTop._二叉树;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
class Solution {
    List<Node> list = new LinkedList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        Node hNode = list.get(0);
        Node pre = list.get(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            node.left = pre;
            pre.right = node;
            pre = node;
        }       
        return hNode; 
    }

    void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};