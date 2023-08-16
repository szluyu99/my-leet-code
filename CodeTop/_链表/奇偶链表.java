package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/odd-even-linked-list/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // 记录第一个偶节点, head 为第一个奇节点
        ListNode firstEven = head.next;
        // 记录当前的奇节点, 当前的偶节点
        ListNode curOdd = head, curEven = firstEven;
        
        while (curOdd != null && curOdd.next != null && curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;
            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        
        curOdd.next = firstEven;
        return head;
    }
}