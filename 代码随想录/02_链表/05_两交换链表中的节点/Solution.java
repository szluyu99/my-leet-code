import common.ListNode;

// https://leetcode.cn/problems/swap-nodes-in-pairs/
// 迭代
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode vn = new ListNode(0, head); // 虚拟头节点
        ListNode cur = vn, tmp = null;
        while (cur != null && cur.next != null && cur.next.next != null) {
            tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = cur.next.next;
            cur.next.next = tmp;
            cur = cur.next.next;
        }
        return vn.next;
    }
}

// 递归
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}