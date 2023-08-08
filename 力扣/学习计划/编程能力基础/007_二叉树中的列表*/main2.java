import common.TreeNode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (dfs(head, root)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
         
    boolean dfs(ListNode head, TreeNode root) {
        // 链表全部匹配完, 匹配成功
        if (head == null) return true;
        // 二叉树访问到空节点, 匹配失败
        if (root == null) return false;
        // 当前二叉树上的节点与链表节点值不相等, 匹配失败
        if (root.val != head.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}