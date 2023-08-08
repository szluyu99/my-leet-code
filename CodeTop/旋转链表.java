package CodeTop;

import common.ListNode;

// https://leetcode.cn/problems/rotate-list/
// 递归
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;

        ListNode node = head, pre = null;
        int size = 1;
        while (node.next != null) {
            pre = node;
            node = node.next;
            size++;
        }
        node.next = head;
        pre.next = null;

        int nextK = (k % size) - 1;
        if (nextK < 0)
            nextK += size;
        return rotateRight(node, nextK);
    }
}

// 迭代
class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 将某个节点指向链表最后, 此时顺便拿到链表长度
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        int i = (size - k % size); // 解决循环问题
        // 将头节点的值往后拼接
        while (i > 0) {
            node.next = new ListNode(head.val);
            head = head.next;
            node = node.next;
            i--;
        }
        return head;
    }
}