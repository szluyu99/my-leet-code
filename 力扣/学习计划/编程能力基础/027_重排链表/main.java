/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 重排链表
 */

/**
 * 模拟
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            moveList(cur);
            cur = cur.next.next;
        }
    }

    /**
     * 将最后一个节点移到首位
     * @param head
     */
    void moveList(ListNode head) {
        ListNode last = head, pre = null;
        while (last.next != null) {
            pre = last;
            last = last.next;
        }
        ListNode temp = head.next;
        head.next = last;
        last.next = temp;
        pre.next = null;
    }
}