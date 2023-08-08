import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
// 层序遍历
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                if (i > 1) node.next = q.peek(); // 除最后一个元素，都指向下一元素
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return root;
    }
}

// 数组模拟队列 - 层序遍历
class Solution1 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node[] q = new Node[6010];
        int hh = 0, tt = 0;
        q[tt++] = root;
        while (hh < tt) {
            int size = tt - hh;
            for (int i = 0; i < size; i++) {
                Node node = q[hh++];
                if (i != size - 1)
                    node.next = q[hh];
                if (node.left != null)
                    q[tt++] = node.left;
                if (node.right != null)
                    q[tt++] = node.right;
            }
        }
        return root;
    }
}

// DFS 解法
class Solution2 {
    public Node connect(Node root) {
        if (root == null) return root;
        // 左右子树都不为 null, 直接连接
        if (root.left != null && root.right != null)
            root.left.next = root.right;
        // 左不为 null, 右为 null, 则右子树的 next 由根的 next 得出
        if (root.left != null && root.right == null)
            root.left.next = getNext(root.next);
        // 右不为 null
        if (root.right != null)
            root.right.next = getNext(root.next);
        connect(root.right); // 必须先 right 再 left
        connect(root.left);
        return root;
    }
    // 找到 node 最左的第一个节点
    Node getNext(Node node) {
        if (node == null) return null;
        // 先尝试找左节点
        if (node.left != null) return node.left;
        // 再尝试找右节点
        if (node.right != null) return node.right;
        // 左右节点都不存在，尝试对 node.next 进行相同操作
        if (node.next != null) return getNext(node.next);
        return null;
    }
}

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