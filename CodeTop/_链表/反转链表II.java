package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/reverse-linked-list-ii/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        head = pre.next;

        // 将当前节点的下一个节点调整为前驱节点的下一个节点
        // 1->2->3 当前节点是 2, 变成 1->3->2
        for (int i = left; i < right; i++) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }

        return dummy.next;
    }
}

class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preNode = dummy;
        
        // 找到 left 的前一个节点
        for (int i = 1; i < left; i++) {
            preNode = preNode.next;
        }

        // 旋转
        ListNode cur = preNode.next, pre = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur; 
            cur = tmp;
        }

        // 连接
        preNode.next.next = cur;
        preNode.next = pre;

        return dummy.next;
    }
}