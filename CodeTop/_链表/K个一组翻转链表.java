package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        ListNode pre = null, cur = head;
        while (cur != node) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}        