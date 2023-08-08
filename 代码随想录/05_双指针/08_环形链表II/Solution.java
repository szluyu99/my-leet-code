import java.util.HashSet;
import java.util.Set;

import common.ListNode;

// https://leetcode.cn/problems/linked-list-cycle-ii/
// 双指针
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 快慢指针判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环, 找环的起始点
                fast = head; // 快指针从头开始
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

// set
class Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head;
    }
}