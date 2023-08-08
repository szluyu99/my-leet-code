class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        helper(root);
        // 头尾节点相互指向
        head.left = pre;
        pre.right = head;
        return head;
    }
    /**
     * 中序遍历将二叉搜索树 中间部分 处理成双向链表
     */
    void helper(Node cur) {
        if (cur == null)
            return;
        helper(cur.left);

        // 处理头部
        if (pre == null) {
            head = cur;
            pre = head;
        } else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        helper(cur.right);
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