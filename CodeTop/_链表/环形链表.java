package CodeTop._链表;

import common.ListNode;

// https://leetcode.cn/problems/linked-list-cycle/submissions/
// 快慢指针
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}