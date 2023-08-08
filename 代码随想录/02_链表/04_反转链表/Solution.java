import common.ListNode;

// https://leetcode.cn/problems/reverse-linked-list/
// 双指针
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

// 递归
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

// 头插法: 空间 O(n)
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        for (ListNode x = head; x != null; x = x.next)
            res = new ListNode(x.val, res);
        return res;
    }
}
