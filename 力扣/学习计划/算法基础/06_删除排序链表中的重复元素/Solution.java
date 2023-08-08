import common.ListNode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
// 迭代
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null)
            if (cur.next != null && cur.next.val == cur.val)
                cur.next = cur.next.next;
            else cur = cur.next;
        return head;
    }
}

// 递归
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }
}