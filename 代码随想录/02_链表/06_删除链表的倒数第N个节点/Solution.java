import common.ListNode;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
// 快慢指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (n-- > 0) fast = fast.next; // 快指针先走 n 步
        if (fast == null) return head.next; // 删除第一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

// 快慢指针 + 虚拟头节点
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vn = new ListNode(0, head);
        ListNode slow = vn, fast = vn;
        while (n-- > 0) fast = fast.next; 
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return vn.next;
    }
}

// 递归
class Solution2 {
    int cur = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd(head.next, n);
        cur++;
        if (cur == n) return head.next;
        return head;
    }
}