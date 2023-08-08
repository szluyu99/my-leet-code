/**
 * 1.快慢指针分出两段链表
 * 2.反转后段链表 
 * 3.拼接两段链表
 */
class Solution {
    public void reorderList(ListNode head) {
        // 快慢指针分出两段链表
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 后半部分的链表头节点
        ListNode later = slow.next;
        slow.next = null; // 断开两部分链表的连接

        later = reverseList(later); // 反转后半部分链表

        // 拼接两段链表
        ListNode front = head;
        while (front != null && later != null) {
            ListNode laterNext = later.next;
            ListNode frontNext = front.next;

            front.next = later;
            later.next = frontNext;

            front = frontNext;
            later = laterNext;
        }

    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}