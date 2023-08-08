package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == n) {
            return head.next;
        }

        cur = head;
        for (int i = 1; i < len - n; i++) {
            cur = cur.next;
        }

        if (cur.next != null) {
            cur.next = cur.next.next;
        }

        return head;
    }
}

// 虚拟头节点 + 快慢指针
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (n-- > 0) fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}