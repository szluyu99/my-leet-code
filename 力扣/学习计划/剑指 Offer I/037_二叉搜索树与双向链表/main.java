import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 暴力，先中序遍历将元素放到 list，然后再次遍历串成 双向链表
 */
class Solution {
    List<Node> list = new LinkedList<>();

    public Node treeToDoublyList(Node root) {
        helper(root);
        Node hNode = list.get(0);
        // pre 一开始指向最后一个节点
        Node pre = list.get(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            // 当前节点和前一节点，构造成双向循环链表
            node.left = pre;
            pre.right = node;
            pre = node;
        }       
        return hNode; 
    }

    void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        list.add(node);
        helper(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};