/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 旋转链表
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 将某个节点指向链表最后, 此时顺便拿到链表长度
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        // 计算头节点后移的次数
        int i = (size - k % size);
        // 将头节点的值往后拼接并后移
        while (i > 0) {
            node.next = new ListNode(head.val);
            head = head.next;
            node = node.next;
            i--;
        }
        return head;
    }
}