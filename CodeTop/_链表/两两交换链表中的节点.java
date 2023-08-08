package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/swap-nodes-in-pairs/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = head; 
        head = tmp;
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}