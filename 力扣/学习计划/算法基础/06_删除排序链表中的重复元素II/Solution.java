import common.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
// 迭代
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode vnode = new ListNode(101, head);
        ListNode pre = vnode, cur = vnode;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return vnode.next;
    }
}

// 递归
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;

        if (head.val == next.val) {
            while (next != null && head.val == next.val)
                next = next.next;
            head = deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }
}