package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode ppre = dummy, pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                int tmp = cur.val;
                while (ppre.next != null && ppre.next.val == tmp) {
                    ppre.next = ppre.next.next;
                } 
                pre = ppre;
                cur = pre.next;
                continue;
            }
            ppre = pre;
            pre = cur; 
            cur = cur.next;
        }
        return dummy.next;
    }
}