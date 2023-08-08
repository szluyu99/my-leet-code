import common.ListNode;

// https://leetcode-cn.com/problems/remove-linked-list-elements/
// 递归
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}

// 迭代
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == val) node.next = node.next.next;
            else node = node.next;
        }
        return head.val == val ? head.next : head;
    }
}

// 迭代（额外空间 - 创建新节点）
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode cur = new ListNode(0), res = cur;
        while (node != null) {
            if (node.val == val) {
                node = node.next;
                continue;
            }
            cur.next = new ListNode(node.val);
            cur = cur.next;
            node = node.next;
        }
        return res.next;
    }
}