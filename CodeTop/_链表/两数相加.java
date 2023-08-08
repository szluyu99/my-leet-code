package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/add-two-numbers/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;

            ListNode sumNode = new ListNode(sum % 10);
            cur.next = sumNode;
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
