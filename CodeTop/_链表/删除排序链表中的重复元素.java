package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
// 递归1
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        while (head != null && head.next != null && head.next.val == head.val) {
            head = head.next;
        }

        head.next = deleteDuplicates(head.next);

        return head;
    }
}

// 递归2
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = deleteDuplicates(head.next);
        if (head.val == head.next.val) return next;
        head.next = next;
        return head;
    }
}

// 迭代
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}