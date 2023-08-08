class Solution {
    /**
     * 递归
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode node = deleteNode(head.next, val);
        head.next = node;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}