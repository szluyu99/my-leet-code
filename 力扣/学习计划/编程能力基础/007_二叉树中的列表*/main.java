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

/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/submissions/
 * 二叉树中的列表
 */
class Solution {
    /**
     * 一个递归做法：应该是正确的，但是超时
     */
    boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (head == null) return true;
        // 找到了与链表首节点相同的树节点
        if (root.val == head.val) {
            // 走到链表尾部, 表示已经找到和链表对应的路径
            if (head.next == null) return true;
            // 沿着这条路径走下去, 能对应上的则返回true
            if (root.left != null && head.next.val == root.left.val 
                && isSubPath(head.next, root.left))
                return true;
            if (root.right != null && head.next.val == root.right.val 
                && isSubPath(head.next, root.right))
                return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}