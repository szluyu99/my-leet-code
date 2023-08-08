import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
// 层序遍历
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                if (i > 1) node.next = q.peek();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return root;
    }
}

// dfs
class Solution1 {
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};